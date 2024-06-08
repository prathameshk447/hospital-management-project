package patient_home_screen;

import admin_home_screen.ProjectHomeScreen;
import appointment_home_screen.AppointmentHomeScreen;
import case_home_screen.CaseHomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import patient_addscreen.ProjectAddPatient;
import patient_deletescreen.ProjectDeletePatient;
import patient_editscreen.ProjectEditPatient;
import patient_searchscreen.ProjectSearchPatient;
import user_home_screen.UserHomeScreen;

public class PatientHomeScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Patients;

  @FXML private Button Cases;

  @FXML private Button Appointments;

  @FXML private Button Users;

  @FXML private Button Logout;

  @FXML private Button AddPatient;

  @FXML private Button EditPatient;

  @FXML private Button DeletePatient;

  @FXML private Button SearchPatient;

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

  public void AddPatient(ActionEvent event) throws Exception {
    ProjectAddPatient projectAddPatient = new ProjectAddPatient();
    projectAddPatient.show();
  }

  public void EditPatient(ActionEvent event) throws Exception {
    ProjectEditPatient projectEditPatient = new ProjectEditPatient();
    projectEditPatient.show();
  }

  public void DeletePatient(ActionEvent event) throws Exception {
    ProjectDeletePatient projectDeletePatient = new ProjectDeletePatient();
    projectDeletePatient.show();
  }

  public void SearchPatient(ActionEvent event) throws Exception {
    ProjectSearchPatient projectSearchPatient = new ProjectSearchPatient();
    projectSearchPatient.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    ProjectHomeScreen projectHomeScreen = new ProjectHomeScreen();
    projectHomeScreen.show();
  }
}
