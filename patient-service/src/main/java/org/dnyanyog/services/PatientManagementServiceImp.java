package org.dnyanyog.services;

import jakarta.validation.Valid;
import java.util.List;
import org.dnyanyog.dto.PatientRequest;
import org.dnyanyog.dto.PatientResponse;
import org.dnyanyog.entity.Patients;
import org.dnyanyog.repo.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientManagementServiceImp {

  @Autowired private PatientsRepository patientRepo;
  @Autowired private PatientResponse response;

  public PatientResponse addPatient(@Valid PatientRequest request) throws Exception {
    try {
      List<Patients> optionalPatient = patientRepo.findBypatientname(request.getPatientName());

      if (!optionalPatient.isEmpty()) {
        response.setStatus("Fail");
        response.setMessage("Failed to add patient!");
        return response;
      }
      Patients p =
          Patients.getInstance()
              .setAddress(request.getAddress())
              .setBirth_date(request.getBirth_date())
              .setFirst_examination_date(request.getFirst_examination_date())
              .setGender(request.getGender())
              .setMobile(request.getMobile())
              .setPatientName(request.getPatientName())
              .setPatientnamemarathi(request.getPatientnamemarathi())
              .generatePatientId()
              .setStatus(Patients.Status.ACTIVE);

      p = patientRepo.save(p);
      populatePatientResponse(response, p);
      response.setStatus("Success");
      response.setMessage("Patient added successfully!");
    } catch (Exception e) {
      response.setStatus("Fail");
      response.setMessage("Failed to add patient!");
    }

    return response;
  }

  public PatientResponse updatePatient(String patient_id, PatientRequest request) {
    List<Patients> optionalPatient = patientRepo.findByPatientId(patient_id);

    if (optionalPatient.isEmpty()) {
      response.setStatus("Fail");
      response.setMessage("Patient not found or invalid request!");
    } else {
      Patients patients = optionalPatient.get(0);

      patients.setAddress(request.getAddress());
      patients.setMobile(request.getMobile());
      patients.setBirth_date(request.getBirth_date());
      patients.setFirst_examination_date(request.getFirst_examination_date());
      patients.setGender(request.getGender());
      patients.setPatientName(request.getPatientName());
      patients.setPatientnamemarathi(request.getPatientnamemarathi());
      patients.generatePatientId();
      patientRepo.save(patients);

      populatePatientResponse(response, patients);
      response.setStatus("Success");
      response.setMessage("Patient updated successfully!");
    }

    return response;
  }

  public PatientResponse getSinglePatient(String patient_id) {
    List<Patients> optionalPatient = patientRepo.findByPatientId(patient_id);

    PatientResponse patientResponse = PatientResponse.getInstance();
    if (optionalPatient.isEmpty()) {

      patientResponse.setStatus("Fail");
      patientResponse.setMessage("Patient not found or invalid request!");
    } else {
      Patients patients = optionalPatient.get(0);
      populatePatientResponse(patientResponse, patients);

      patientResponse.setStatus("Success");
      patientResponse.setMessage("Patient found successfully!");
    }
    return patientResponse;
  }

  public PatientResponse deletePatient(String patient_id) {

    List<Patients> optionalPatient = patientRepo.findByPatientId(patient_id);

    if (optionalPatient.isEmpty()) {
      response.setMessage("Patient not deleted !");
      response.setStatus("Fail");
    } else {

      Patients patients = optionalPatient.get(0);
      patients.setStatus(Patients.Status.DELETED);
      patientRepo.save(patients);

      response.setMessage("Patient deleted successfully !");
      response.setStatus("Success");
      populatePatientResponse(response, patients);
    }
    return response;
  }

  private void populatePatientResponse(PatientResponse response, Patients patient) {
    response.setAddress(patient.getAddress());
    response.setBirth_date(patient.getBirth_date());
    response.setFirst_examination_date(patient.getFirst_examination_date());
    response.setGender(patient.getGender());
    response.setMobile(patient.getMobile());
    response.setPatientName(patient.getPatientName());
    response.setPatientnamemarathi(patient.getPatientnamemarathi());
  }
}
