package user_home_screen;

import admin_home_screen.ProjectHomeScreen;
import appointment_home_screen.AppointmentHomeScreen;
import case_home_screen.CaseHomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import patient_home_screen.PatientHomeScreen;
import user_addscreen.ProjectAddUser;
import user_deletescreen.ProjectDeleteUser;
import user_editscreen.ProjectEditUser;
import user_searchscreen.ProjectSearchUser;

public class UserHomeScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Patients;

  @FXML private Button Cases;

  @FXML private Button Appointments;

  @FXML private Button Users;

  @FXML private Button Logout;

  @FXML private Button AddUser;

  @FXML private Button EditUser;

  @FXML private Button DeleteUser;

  @FXML private Button SearchUser;

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

  public void AddUser(ActionEvent event) throws Exception {
    ProjectAddUser projectAddUser = new ProjectAddUser();
    projectAddUser.show();
  }

  public void EditUser(ActionEvent event) throws Exception {
    ProjectEditUser projectEditUser = new ProjectEditUser();
    projectEditUser.show();
  }

  public void DeleteUser(ActionEvent event) throws Exception {
    ProjectDeleteUser projectDeleteUser = new ProjectDeleteUser();
    projectDeleteUser.show();
  }

  public void SearchUser(ActionEvent event) throws Exception {
    ProjectSearchUser projectSearchUser = new ProjectSearchUser();
    projectSearchUser.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    ProjectHomeScreen projectHomeScreen = new ProjectHomeScreen();
    projectHomeScreen.show();
  }
}
