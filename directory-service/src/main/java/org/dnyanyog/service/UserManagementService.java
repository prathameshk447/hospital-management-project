package org.dnyanyog.service;

import jakarta.validation.Valid;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;

public interface UserManagementService {
  public UserResponse addUser(@Valid UserRequest request) throws Exception;

  public UserResponse updateUser(long patient_id, UserRequest request);

  public UserResponse getSingleUser(long patient_id);

  public UserResponse deleteUser(long patient_id);
}
