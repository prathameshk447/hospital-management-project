package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class CaseResponse {
  private String patientname;

  private String patientId;

  private String case_number;

  private String examination_date;

  private String symptoms;

  private String prescription;

  private String status;

  private String message;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPatientName() {
    return patientname;
  }

  public void setPatientName(String patientname) {
    this.patientname = patientname;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getCase_number() {
    return case_number;
  }

  public void setCase_number(String case_number) {
    this.case_number = case_number;
  }

  public String getExamination_date() {
    return examination_date;
  }

  public void setExamination_date(String examination_date) {
    this.examination_date = examination_date;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public void setSymptoms(String symptoms) {
    this.symptoms = symptoms;
  }

  public String getPrescription() {
    return prescription;
  }

  public void setPrescription(String prescription) {
    this.prescription = prescription;
  }

  public String getCaseId() { // TODO Auto-generated method stub
    return null;
  }
}
