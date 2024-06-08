package org.dnyanyog.service;

import java.util.List;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp {

  @Autowired UserRepository userRepo;

  public LoginResponse validateUser(LoginRequest loginRequest) {
    LoginResponse response = new LoginResponse();
    List<Users> usersList = userRepo.findBymobilenumber(loginRequest.getMobileNumber());

    if (usersList.size() == 1) {
      Users userData = usersList.get(0);

      String Password = userData.getPassword();

      if (loginRequest.getPassword() != null) {
        String inputPassword = (loginRequest.getPassword());

        if (inputPassword.equalsIgnoreCase(Password)) {
          response.setStatus("Success");
          response.setMessage("Login Successful");

        } else {
          response.setStatus("Fail");
          response.setMessage("Login Failed");
        }
      } else {
        response.setStatus("Fail");
        response.setMessage("Password or encryption key is null");
      }
    } else {
      response.setStatus("Fail");
      response.setMessage("Login Failed");
    }
    return response;
  }
}
