package org.dnyanyog.service;

import jakarta.validation.Valid;
import java.util.List;
import org.dnyanyog.dto.CaseRequest;
import org.dnyanyog.dto.CaseResponse;
import org.dnyanyog.entity.Cases;
import org.dnyanyog.repo.CaseServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseServiceImp {

  @Autowired private CaseServiceRepository caseRepo;
  @Autowired private CaseResponse response;

  public CaseResponse addCase(@Valid CaseRequest request) throws Exception {
    try {
      List<Cases> optionalCase = caseRepo.findBypatientname(request.getPatientName());

      if (!optionalCase.isEmpty()) {
        response.setStatus("Fail");
        response.setMessage("Failed to add case!");
        return response;
      }
      Cases c =
          Cases.getInstance()
              .setCase_number(request.getCase_number())
              .setExamination_date(request.getExamination_date())
              .setPatientName(request.getPatientName())
              .setPrescription(request.getPrescription())
              .setSymptoms(request.getSymptoms())
              .setStatus(Cases.Status.ACTIVE)
              .generateCaseId()
              .generatePatientId()
              .generateCaseId();

      c = caseRepo.save(c);
      populatedCaseResponse(response, c);
      response.setStatus("Success");
      response.setMessage("Case added successfully!");
    } catch (Exception e) {
      response.setStatus("Fail");
      response.setMessage("Failed to add case!");
    }
    return response;
  }

  public CaseResponse updateCase(String case_id, CaseRequest request) {
    List<Cases> optionalCases = caseRepo.findByCaseId(case_id);

    if (optionalCases.isEmpty()) {
      response.setStatus("Fail");
      response.setMessage("Case not found or invalid request!");
    } else {
      Cases cases = optionalCases.get(0);

      cases.setCase_number(request.getCase_number());
      cases.setExamination_date(request.getExamination_date());
      cases.setPatientId(request.getPatientId());
      cases.setPatientName(request.getPatientName());
      cases.setPrescription(request.getPrescription());
      cases.setSymptoms(request.getSymptoms());
      cases.generatePatientId();
      cases.generateCaseId();
      caseRepo.save(cases);

      populatedCaseResponse(response, cases);
      response.setMessage("Success");
      response.setStatus("Case updated successfully!");
    }

    return response;
  }

  public CaseResponse getSingleCase(String patient_id) {
    List<Cases> optionalCase = caseRepo.findByPatientId(patient_id);

    if (optionalCase.isEmpty()) {
      response.setMessage("Fail");
      response.setStatus("Case not found or invalid request!");
    } else {
      Cases cases = optionalCase.get(0);
      populatedCaseResponse(response, cases);
      response.setMessage("Success");
      response.setStatus("Case found successfully!");
    }
    return response;
  }

  public CaseResponse getCase(String case_id) {
    List<Cases> optionalCase = caseRepo.findByCaseId(case_id);

    if (optionalCase.isEmpty()) {
      response.setMessage("Fail");
      response.setStatus("Case not found or invalid request!");
    } else {
      Cases cases = optionalCase.get(0);
      populatedCaseResponse(response, cases);
      response.setMessage("Success");
      response.setStatus("Case found successfully!");
    }
    return response;
  }

  public CaseResponse deleteCase(String case_id) {
    List<Cases> optionalCase = caseRepo.findByCaseId(case_id);

    if (optionalCase.isEmpty()) {
      response.setMessage("Fail");
      response.setStatus("Case not deleted !");
    } else {
      Cases cases = optionalCase.get(0);
      cases.setStatus(Cases.Status.DELETED);
      caseRepo.save(cases);

      response.setMessage("Success");
      response.setStatus("Case deleted successfully !");
      populatedCaseResponse(response, cases);
    }
    return response;
  }

  private void populatedCaseResponse(CaseResponse response, Cases cases) {
    response.setCase_number(cases.getCase_number());
    response.setExamination_date(cases.getExamination_date());
    response.setPatientId(cases.getPatientId());
    response.setPatientName(cases.getPatientName());
    response.setPrescription(cases.getPrescription());
    response.setSymptoms(cases.getSymptoms());
  }
}
