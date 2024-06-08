package case_home_screen;

import admin_home_screen.ProjectHomeScreen;
import appointment_home_screen.AppointmentHomeScreen;
import case_addscreen.ProjectAddCase;
import case_deletescreen.ProjectDeleteCase;
import case_editscreen.ProjectUpdateCase;
import case_searchscreen.ProjectSearchCase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import patient_home_screen.PatientHomeScreen;
import user_home_screen.UserHomeScreen;

public class CaseHomeScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Patients;

  @FXML private Button Cases;

  @FXML private Button Appointments;

  @FXML private Button Users;

  @FXML private Button Logout;

  @FXML private Button AddCase;

  @FXML private Button EditCase;

  @FXML private Button DeleteCase;

  @FXML private Button SearchCase;

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

  public void AddCase(ActionEvent event) throws Exception {
    ProjectAddCase projectAddCase = new ProjectAddCase();
    projectAddCase.show();
  }

  public void EditCase(ActionEvent event) throws Exception {
    ProjectUpdateCase projectUpdateCase = new ProjectUpdateCase();
    projectUpdateCase.show();
  }

  public void DeleteCase(ActionEvent event) throws Exception {
    ProjectDeleteCase projectDeleteCase = new ProjectDeleteCase();
    projectDeleteCase.show();
  }

  public void SearchCase(ActionEvent event) throws Exception {
    ProjectSearchCase projectSearchCase = new ProjectSearchCase();
    projectSearchCase.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    ProjectHomeScreen projectHomeScreen = new ProjectHomeScreen();
    projectHomeScreen.show();
  }
}
