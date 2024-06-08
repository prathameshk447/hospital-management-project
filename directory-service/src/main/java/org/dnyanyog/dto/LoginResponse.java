package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginResponse {
  private String mobilenumber;
  private String password;
  private String status;
  private String message;

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
}
