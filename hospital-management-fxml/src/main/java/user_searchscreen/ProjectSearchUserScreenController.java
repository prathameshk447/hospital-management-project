package user_searchscreen;

import admin_home_screen.ProjectHomeScreen;
import appointment_home_screen.AppointmentHomeScreen;
import case_home_screen.CaseHomeScreen;
import common.RestUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.dnyanyog.dto.UserResponse;
import patient_home_screen.PatientHomeScreen;
import projectlogin.ProjectLoginScreen;
import user_home_screen.UserHomeScreen;

public class ProjectSearchUserScreenController {

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

  @FXML private Button Logout;

  @FXML private Button Search;

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

  public void Search(ActionEvent event) throws Exception {
    String patient_id = Patient_id.getText().trim();

    UserResponse response = null;

    response =
        RestUtil.sendGetRequest(
            "http://localhost:8081/api/v1/directory/" + patient_id, UserResponse.class);

    UserName.setText(response.getUserName());

    MobileNumber.setText(response.getMobileNumber());
    Role.setText(response.getRole());
    Email.setText(response.getEmail());
    Password.setText(response.getPassword());
    Confirm_password.setText(response.getConfirm_password());
  }

  public void Cancel(ActionEvent event) throws Exception {
    UserHomeScreen userHomeScreen = new UserHomeScreen();
    userHomeScreen.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    new ProjectLoginScreen().show();
  }
}
