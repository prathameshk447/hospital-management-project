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
public class Appointment {

  @GeneratedValue
  @Id
  @Column(nullable = false, insertable = true, updatable = false)
  private long patient_code;

  @Column(name = "patientname", nullable = false, insertable = true, updatable = false)
  private String patientname;

  @Column(name = "patient_id", nullable = false, insertable = true, updatable = false)
  private String patientId;

  @Column(name = "appointment_id", nullable = false, insertable = true, updatable = false)
  private String appointmentId;

  @Column private String appointment_time;

  @Column private String examination_date;

  public static Appointment getInstance() {
    return new Appointment();
  }

  public enum Status {
    ACTIVE,
    EXPIRED,
    DELETED
  }

  @Enumerated(EnumType.STRING)
  private Status status;

  public Status getStatus() {
    return status;
  }

  public Appointment setStatus(Status status) {
    this.status = status;
    return this;
  }

  public long getPatient_code() {
    return patient_code;
  }

  public Appointment setPatient_code(long patient_code) {
    this.patient_code = patient_code;
    return this;
  }

  public String getPatientName() {
    return patientname;
  }

  public Appointment setPatientName(String patientname) {
    this.patientname = patientname;
    return this;
  }

  public String getPatientId() {
    return patientId;
  }

  public Appointment setPatientId(String patientId) {
    this.patientId = patientId;
    return this;
  }

  public String getAppointmentId() {
    return appointmentId;
  }

  public Appointment setAppointmentId(String appointmentId) {
    this.appointmentId = appointmentId;
    return this;
  }

  public String getAppointment_time() {
    return appointment_time;
  }

  public Appointment setAppointment_time(String appointment_time) {
    this.appointment_time = appointment_time;
    return this;
  }

  public String getExamination_date() {
    return examination_date;
  }

  public Appointment setExamination_date(String examination_date) {
    this.examination_date = examination_date;
    return this;
  }

  private String generateRandomAlphanumeric(int length) {
    return UUID.randomUUID().toString().replace("-", "").substring(0, length).toUpperCase();
  }

  public Appointment generateAppointmentId() {
    this.appointmentId = "APT" + generateRandomAlphanumeric(8);
    return this;
  }

  public Appointment generatePatientId() {
    this.patientId = "PAT" + generateRandomAlphanumeric(8);
    return this;
  }
}
