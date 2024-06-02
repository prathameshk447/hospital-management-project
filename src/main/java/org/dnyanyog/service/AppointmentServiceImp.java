package org.dnyanyog.service;

import jakarta.validation.Valid;
import java.util.List;
import org.dnyanyog.dto.AppointmentRequest;
import org.dnyanyog.dto.AppointmentResponse;
import org.dnyanyog.entity.Appointment;
import org.dnyanyog.repo.AppointmentServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImp {

  @Autowired private AppointmentServiceRepository appointmentRepo;
  @Autowired private AppointmentResponse response;

  public AppointmentResponse addAppointment(@Valid AppointmentRequest request) throws Exception {
    try {
      List<Appointment> optionalAppointment =
          appointmentRepo.findBypatientname(request.getPatientName());

      if (!optionalAppointment.isEmpty()) {
        response.setStatus("Fail");
        response.setMessage("Failed to add Appointment!");
        return response;
      }
      Appointment a =
          Appointment.getInstance()
              .setAppointment_time(request.getAppointment_time())
              .setPatientName(request.getPatientName())
              .setExamination_date(request.getExamination_date())
              .setStatus(Appointment.Status.ACTIVE)
              .generateAppointmentId()
              .generatePatientId();

      a = appointmentRepo.save(a);
      populatedCaseResponse(response, a);
      response.setStatus("Success");
      response.setMessage("Appointment added successfully!");
    } catch (Exception e) {
      response.setStatus("Fail");
      response.setMessage("Failed to add Appointment!");
    }
    return response;
  }

  public AppointmentResponse updateAppointment(String appointment_id, AppointmentRequest request) {
    List<Appointment> optionalAppointment = appointmentRepo.findByAppointmentId(appointment_id);

    if (optionalAppointment.isEmpty()) {
      response.setStatus("Fail");
      response.setMessage("Appointment not found or invalid request!");
    } else {
      Appointment appointment = optionalAppointment.get(0);

      appointment.setAppointment_time(request.getAppointment_time());
      appointment.setExamination_date(request.getExamination_date());
      appointment.setPatientId(request.getPatientId());
      appointment.setPatientName(request.getPatientName());
      appointment.setAppointmentId(request.getAppointmentId());

      appointmentRepo.save(appointment);

      populatedCaseResponse(response, appointment);
      response.setMessage("Success");
      response.setStatus("Appointment updated successfully!");
    }

    return response;
  }

  public AppointmentResponse getSingleAppointment(String patient_id) {
    List<Appointment> optionalAppointment = appointmentRepo.findByPatientId(patient_id);

    if (optionalAppointment.isEmpty()) {
      response.setMessage("Fail");
      response.setStatus("Appointment not found or invalid request!");
    } else {
      Appointment appointment = optionalAppointment.get(0);
      populatedCaseResponse(response, appointment);
      response.setMessage("Success");
      response.setStatus("Appointment found successfully!");
    }
    return response;
  }

  public AppointmentResponse getAppointment(String appointment_id) {
    List<Appointment> optionalAppointment = appointmentRepo.findByAppointmentId(appointment_id);

    if (optionalAppointment.isEmpty()) {
      response.setMessage("Fail");
      response.setStatus("Appointment not found or invalid request!");
    } else {
      Appointment appointment = optionalAppointment.get(0);
      populatedCaseResponse(response, appointment);
      response.setMessage("Success");
      response.setStatus("Appointment found successfully!");
    }
    return response;
  }

  public AppointmentResponse deleteAppointment(String appointment_id) {
    List<Appointment> optionalAppointment = appointmentRepo.findByAppointmentId(appointment_id);

    if (optionalAppointment.isEmpty()) {
      response.setMessage("Fail");
      response.setStatus("Appointment not deleted !");
    } else {
      Appointment appointment = optionalAppointment.get(0);
      appointment.setStatus(Appointment.Status.DELETED);
      appointmentRepo.save(appointment);

      response.setMessage("Success");
      response.setStatus("Appointment deleted successfully !");
      populatedCaseResponse(response, appointment);
    }
    return response;
  }

  private void populatedCaseResponse(AppointmentResponse response, Appointment appointment) {
    response.setAppointment_time(appointment.getAppointment_time());
    response.setExamination_date(appointment.getExamination_date());
    response.setPatientId(appointment.getPatientId());
    response.setPatientName(appointment.getPatientName());
    response.setAppointmentId(appointment.getAppointmentId());
  }
}
