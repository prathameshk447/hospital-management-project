package org.dnyanyog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Cases {

  @GeneratedValue @Id @Column private long patient_code;

  @Column private String patientname;

  @Column private String patientId;

  @Column private String caseId;

  @Column private String case_number;

  @Column private String examination_date;

  @Column private String symptoms;

  @Column private String prescription;

  public enum Status {
    ACTIVE,
    EXPIRED,
    DELETED
  }

  @Enumerated(EnumType.STRING)
  private Status status;

  public static Cases getInstance() {
    return new Cases();
  }

  public Status getStatus() {
    return status;
  }

  public Cases setStatus(Status status) {
    this.status = status;
    return this;
  }

  public long getPatient_code() {
    return patient_code;
  }

  public Cases setPatient_code(long patient_code) {
    this.patient_code = patient_code;
    return this;
  }

  public String getPatientName() {
    return patientname;
  }

  public Cases setPatientName(String patientname) {
    this.patientname = patientname;
    return this;
  }

  public String getPatientId() {
    return patientId;
  }

  public Cases setPatientId(String patientId) {
    this.patientId = patientId;
    return this;
  }

  public String getCase_number() {
    return case_number;
  }

  public Cases setCase_number(String case_number) {
    this.case_number = case_number;
    return this;
  }

  public String getExamination_date() {
    return examination_date;
  }

  public Cases setExamination_date(String examination_date) {
    this.examination_date = examination_date;
    return this;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public Cases setSymptoms(String symptoms) {
    this.symptoms = symptoms;
    return this;
  }

  public String getPrescription() {
    return prescription;
  }

  public Cases setPrescription(String prescription) {
    this.prescription = prescription;
    return this;
  }

  private String generateRandomAlphanumeric(int length) {
    return UUID.randomUUID().toString().replace("-", "").substring(0, length).toUpperCase();
  }

  public Cases generateCaseId() {
    this.caseId = "CAS" + generateRandomAlphanumeric(8);
    return this;
  }

  public Cases generatePatientId() {
    this.patientId = "PAT" + generateRandomAlphanumeric(8);
    return this;
  }
}
