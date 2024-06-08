package user_editscreen;

import admin_home_screen.ProjectHomeScreen;
import appointment_home_screen.AppointmentHomeScreen;
import case_home_screen.CaseHomeScreen;
import common.RestUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import patient_home_screen.PatientHomeScreen;
import projectlogin.ProjectLoginScreen;
import user_home_screen.UserHomeScreen;

public class ProjectEditUserScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Patients;

  @FXML private Button Cases;

  @FXML private Button Appointments;

  @FXML private Button Users;

  @FXML private TextField Patient_id;

  @FXML private TextField UserName;

  @FXML private TextField Email;

  @FXML private TextField MobileNumber;

  @FXML private TextField Role;

  @FXML private TextField Password;

  @FXML private TextField Confirm_password;

  @FXML private Button Cancel;

  @FXML private Button Save;

  @FXML private Button Update;

  @FXML private Button Logout;

  public void Dashboard(ActionEvent event) throws Exception {
    ProjectHomeScreen projectHomeScreen = new ProjectHomeScreen();
    projectHomeScreen.show();
  }

  public void Patients(ActionEvent event) throws Exception {
    PatientHomeScreen patientHomeScreen = new PatientHomeScreen();
    patientHomeScreen.show();
  }

  public void Cases(ActionEvent event) throws Exception {
    CaseHomeScreen caseHomeScreen = new CaseHomeScreen();
    caseHomeScreen.show();
  }

  public void Appointments(ActionEvent event) throws Exception {
    AppointmentHomeScreen appointmentHomeScreen = new AppointmentHomeScreen();
    appointmentHomeScreen.show();
  }

  public void Users(ActionEvent event) throws Exception {
    UserHomeScreen userHomeScreen = new UserHomeScreen();
    userHomeScreen.show();
  }

  public void Save(ActionEvent event) throws Exception {}

  public void Update(ActionEvent event) throws Exception {

    UserRequest UpdateUser = new UserRequest();

    UpdateUser.setUserName(UserName.getText());
    UpdateUser.setEmail(Email.getText());
    UpdateUser.setMobileNumber(MobileNumber.getText());
    UpdateUser.setRole(Role.getText());
    UpdateUser.setPassword(Password.getText());
    UpdateUser.setConfirm_password(Confirm_password.getText());

    String patient_id = Patient_id.getText();
    UserResponse response =
        RestUtil.sendPostRequest(
            "http://localhost:8081/api/v1/directory/" + patient_id, UserResponse.class, UpdateUser);
    System.out.println("User updated successfully");
  }

  public void Cancel(ActionEvent event) throws Exception {
    UserHomeScreen userHomeScreen = new UserHomeScreen();
    userHomeScreen.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    new ProjectLoginScreen().show();
  }
}
