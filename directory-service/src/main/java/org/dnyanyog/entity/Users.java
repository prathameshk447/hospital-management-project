package org.dnyanyog.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users {

  @GeneratedValue @Id @Column private long patient_id;

  @Column private String userName;

  @Column private String email;

  @Column private String mobilenumber;

  @Column private String role;

  @Column private String password;

  @Column private String confirm_password;

  public enum Status {
    ACTIVE,
    EXPIRED,
    DELETED
  }

  @Enumerated(EnumType.STRING)
  private Status status;

  public static Users getInstance() {
    return new Users();
  }

  public long getPatient_id() {
    return patient_id;
  }

  public Users setPatient_id(long patient_id) {
    this.patient_id = patient_id;
    return this;
  }

  public String getUserName() {
    return userName;
  }

  public Users setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Users setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getMobileNumber() {
    return mobilenumber;
  }

  public Users setMobileNumber(String mobilenumber) {
    this.mobilenumber = mobilenumber;
    return this;
  }

  public String getRole() {
    return role;
  }

  public Users setRole(String role) {
    this.role = role;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public Users setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getConfirm_password() {
    return confirm_password;
  }

  public Users setConfirm_password(String confirm_password) {
    this.confirm_password = confirm_password;
    return this;
  }

  public Status getStatus() {
    return status;
  }

  public Users setStatus(Status status) {
    this.status = status;
    return this;
  }
}
