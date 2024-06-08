package org.dnyanyog.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patients {

  @GeneratedValue @Id @Column private long patient_code;

  @Column private String patientId;

  @Column private String patientname;

  @Column private String patientnamemarathi;

  @Column private String mobile;

  @Column private String gender;

  @Column private String birth_date;

  @Column private String first_examination_date;

  @Column private String address;

  public enum Status {
    ACTIVE,
    EXPIRED,
    DELETED
  }

  @Enumerated(EnumType.STRING)
  private Status status;

  public static Patients getInstance() {
    return new Patients();
  }

  public Status getStatus() {
    return status;
  }

  public Patients setStatus(Status status) {
    this.status = status;
    return this;
  }

  public long getPatient_code() {
    return patient_code;
  }

  public Patients setPatient_code(long patient_code) {
    this.patient_code = patient_code;
    return this;
  }

  public String getPatientId() {
    return patientId;
  }

  public Patients setPatientId(String patientId) {
    this.patientId = patientId;
    return this;
  }

  public String getPatientName() {
    return patientname;
  }

  public Patients setPatientName(String patientname) {
    this.patientname = patientname;
    return this;
  }

  public String getPatientnamemarathi() {
    return patientnamemarathi;
  }

  public Patients setPatientnamemarathi(String patientnamemarathi) {
    this.patientnamemarathi = patientnamemarathi;
    return this;
  }

  public String getMobile() {
    return mobile;
  }

  public Patients setMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public Patients setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public String getBirth_date() {
    return birth_date;
  }

  public Patients setBirth_date(String birth_date) {
    this.birth_date = birth_date;
    return this;
  }

  public String getFirst_examination_date() {
    return first_examination_date;
  }

  public Patients setFirst_examination_date(String first_examination_date) {
    this.first_examination_date = first_examination_date;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Patients setAddress(String address) {
    this.address = address;
    return this;
  }

  private String generateRandomAlphanumeric(int length) {
    return UUID.randomUUID().toString().replace("-", "").substring(0, length).toUpperCase();
  }

  public Patients generatePatientId() {
    this.patientId = "PAT" + generateRandomAlphanumeric(8);
    return this;
  }
}
