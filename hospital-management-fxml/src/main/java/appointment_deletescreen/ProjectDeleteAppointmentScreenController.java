package appointment_deletescreen;

import admin_home_screen.ProjectHomeScreen;
import appointment_home_screen.AppointmentHomeScreen;
import case_home_screen.CaseHomeScreen;
import common.RestUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.dnyanyog.dto.AppointmentResponse;
import patient_home_screen.PatientHomeScreen;
import projectlogin.ProjectLoginScreen;
import user_home_screen.UserHomeScreen;

public class ProjectDeleteAppointmentScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Patients;

  @FXML private Button Cases;

  @FXML private Button Appointments;

  @FXML private Button Users;

  @FXML private TextField AppointmentId;

  @FXML private Button Cancel;

  @FXML private Button Delete;

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

  public void Delete(ActionEvent event) throws Exception {
    String appointment_id = AppointmentId.getText().trim();

    AppointmentResponse response =
        RestUtil.sendDeleteRequest(
            "http://localhost:8084/api/v1/appointment/" + appointment_id,
            AppointmentResponse.class);
    AppointmentId.clear();
    System.out.println("appointment deleted successfully");
  }

  public void Cancel(ActionEvent event) throws Exception {
    AppointmentHomeScreen appointmentHomeScreen = new AppointmentHomeScreen();
    appointmentHomeScreen.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    new ProjectLoginScreen().show();
  }
}
