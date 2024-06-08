package org.dnyanyog.controller;

import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.service.UserManagementSeriveImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {

  @Autowired UserManagementSeriveImp userservice;

  @PostMapping(
      path = "/api/v1/directory/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public UserResponse addUser(@RequestBody UserRequest userRequest) throws Exception {
    return userservice.addUser(userRequest);
  }

  @GetMapping(path = "/api/v1/directory/{patient_id}")
  public UserResponse getSingleUser(@PathVariable long patient_id) {

    return userservice.getSingleUser(patient_id);
  }

  @DeleteMapping(path = "/api/v1/directory/{patient_id}")
  public UserResponse deleteUser(@PathVariable long patient_id) {
    return userservice.deleteUser(patient_id);
  }

  @PostMapping(path = "/api/v1/directory/{patient_id}")
  public UserResponse updateUser(
      @PathVariable long patient_id, @RequestBody UserRequest userRequest) {
    return userservice.updateUser(patient_id, userRequest);
  }
}
