package appointment_home_screen;

import admin_home_screen.ProjectHomeScreen;
import appointment_addscreen.ProjectAddAppointment;
import appointment_deletescreen.ProjectDeleteAppointment;
import appointment_editscreen.ProjectEditAppointment;
import appointment_searchscreen.ProjectSearchAppointment;
import case_home_screen.CaseHomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import patient_home_screen.PatientHomeScreen;
import user_home_screen.UserHomeScreen;

public class AppointmentHomeScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Patients;

  @FXML private Button Cases;

  @FXML private Button Appointments;

  @FXML private Button Users;

  @FXML private Button Logout;

  @FXML private Button AddAppointment;

  @FXML private Button EditAppointment;

  @FXML private Button DeleteAppointment;

  @FXML private Button SearchAppointment;

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

  public void AddAppointment(ActionEvent event) throws Exception {
    ProjectAddAppointment projectAddAppointment = new ProjectAddAppointment();
    projectAddAppointment.show();
  }

  public void EditAppointment(ActionEvent event) throws Exception {
    ProjectEditAppointment projectEditAppointment = new ProjectEditAppointment();
    projectEditAppointment.show();
  }

  public void DeleteAppointment(ActionEvent event) throws Exception {
    ProjectDeleteAppointment projectDeleteAppointment = new ProjectDeleteAppointment();
    projectDeleteAppointment.show();
  }

  public void SearchAppointment(ActionEvent event) throws Exception {
    ProjectSearchAppointment projectSearchAppointment = new ProjectSearchAppointment();
    projectSearchAppointment.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    ProjectHomeScreen projectHomeScreen = new ProjectHomeScreen();
    projectHomeScreen.show();
  }
}
