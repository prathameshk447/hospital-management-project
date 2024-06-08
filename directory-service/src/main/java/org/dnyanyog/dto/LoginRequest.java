package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginRequest {
  private String mobilenumber;
  private String password;

  public String getMobileNumber() {
    return mobilenumber;
  }

  public void setMobileNumber(String mobilenumber) {
    this.mobilenumber = mobilenumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
