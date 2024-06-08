package org.dnyanyog.service;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementSeriveImp {

  @Autowired private UserRepository userRepo;
  @Autowired private UserResponse response;

  public UserResponse addUser(@Valid UserRequest request) throws Exception {
    try {

      List<Users> optionalUser = userRepo.findByuserName(request.getUserName());

      if (!optionalUser.isEmpty()) {
        response.setStatus("Fail");
        response.setMessage("Failed to add User!");
        return response;
      }

      Users u =
          Users.getInstance()
              .setConfirm_password(request.getConfirm_password())
              .setEmail(request.getEmail())
              .setMobileNumber(request.getMobileNumber())
              .setPassword(request.getPassword())
              .setRole(request.getRole())
              .setUserName(request.getUserName())
              .setStatus(Users.Status.ACTIVE);

      u = userRepo.save(u);
      response.setStatus("Success");
      response.setMessage("User added successfully!");
      populateUserResponse(response, u);

    } catch (Exception e) {
      response.setStatus("Fail");
      response.setMessage("Failed to add User!");
    }

    return response;
  }

  public UserResponse updateUser(long patient_id, UserRequest request) {

    Optional<Users> optionalUser = userRepo.findById(patient_id);

    if (optionalUser.isEmpty()) {
      response.setMessage("Fail");
      response.setStatus("User not found or invalid request!");
    } else {
      Users user = optionalUser.get();

      if (request.getConfirm_password() != null) {
        user.setConfirm_password(request.getConfirm_password());
      }
      if (request.getPassword() != null) {
        user.setPassword(request.getPassword());
      }
      user.setEmail(request.getEmail());
      user.setMobileNumber(request.getMobileNumber());
      user.setRole(request.getRole());
      user.setUserName(request.getUserName());

      userRepo.save(user);

      populateUserResponse(response, user);
      response.setMessage("Success");
      response.setStatus("User updated successfully!");
    }
    return response;
  }

  public UserResponse getSingleUser(long patient_id) {
    Optional<Users> optionalUser = userRepo.findById(patient_id);

    UserResponse userResponse = UserResponse.getInstance();
    if (optionalUser.isEmpty()) {
      userResponse.setMessage("Fail");
      userResponse.setStatus("User not found or invalid request!");
    } else {
      Users user = optionalUser.get();
      populateUserResponse(userResponse, user);
      userResponse.setMessage("Success");
      userResponse.setStatus("User found successfully!");
    }
    return userResponse;
  }

  public UserResponse deleteUser(long patient_id) {
    Optional<Users> optionalUser = userRepo.findById(patient_id);

    if (optionalUser.isEmpty()) {
      response.setMessage("Fail");
      response.setStatus("User not deleted !");
    } else {
      Users user = optionalUser.get();
      user.setStatus(Users.Status.DELETED);
      userRepo.save(user);

      response.setMessage("Success");
      response.setStatus("User deleted successfully !");
      populateUserResponse(response, user);
    }
    return response;
  }

  private void populateUserResponse(UserResponse response, Users users) {

    response.setEmail(users.getEmail());
    response.setMobileNumber(users.getMobileNumber());
    response.setRole(users.getRole());
    response.setUserName(users.getUserName());
  }
}
