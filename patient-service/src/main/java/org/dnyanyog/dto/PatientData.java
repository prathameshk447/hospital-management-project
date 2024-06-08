package org.dnyanyog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class PatientData {

  private String patientname;

  private String patientnamemarathi;

  private String mobile;

  private String gender;

  private String birth_date;

  private String first_examination_date;

  private String address;

  public String getPatientName() {
    return patientname;
  }

  public void setPatientName(String patientname) {
    this.patientname = patientname;
  }

  public String getPatientnamemarathi() {
    return patientnamemarathi;
  }

  public void setPatientnamemarathi(String patientnamemarathi) {
    this.patientnamemarathi = patientnamemarathi;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getBirth_date() {
    return birth_date;
  }

  public void setBirth_date(String birth_date) {
    this.birth_date = birth_date;
  }

  public String getFirst_examination_date() {
    return first_examination_date;
  }

  public void setFirst_examination_date(String first_examination_date) {
    this.first_examination_date = first_examination_date;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
