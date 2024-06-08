package appointment_searchscreen;

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

public class ProjectSearchAppointmentScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Patients;

  @FXML private Button Cases;

  @FXML private Button Appointments;

  @FXML private Button Users;

  @FXML private TextField PatientName;

  @FXML private TextField Appointment_time;

  @FXML private TextField Examination_date;

  @FXML private TextField AppointmentId;

  @FXML private TextField PatientId;

  @FXML private Button Cancel;

  @FXML private Button SearchByAppointment;

  @FXML private Button SearchByPatient;

  @FXML private Button Save;

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

  public void SearchByAppointment(ActionEvent event) throws Exception {

    String appointment_id = AppointmentId.getText().trim();

    AppointmentResponse response = null;

    response =
        RestUtil.sendGetRequest(
            "http://localhost:8084/api/v1/appointment/" + appointment_id,
            AppointmentResponse.class);

    PatientName.setText(response.getPatientName());

    AppointmentId.setText(response.getAppointmentId());
    Examination_date.setText(response.getExamination_date());
    Appointment_time.setText(response.getAppointment_time());
    PatientId.setText(response.getPatientId());
  }

  public void SearchByPatient(ActionEvent event) throws Exception {
    String patient_id = PatientId.getText().trim();

    AppointmentResponse response = null;

    response =
        RestUtil.sendGetRequest(
            "http://localhost:8084/api/v1/appointment/patient/" + patient_id,
            AppointmentResponse.class);

    PatientName.setText(response.getPatientName());

    AppointmentId.setText(response.getAppointmentId());
    Examination_date.setText(response.getExamination_date());
    Appointment_time.setText(response.getAppointment_time());
    PatientId.setText(response.getPatientId());
  }

  public void Cancel(ActionEvent event) throws Exception {
    PatientHomeScreen patientHomeScreen = new PatientHomeScreen();
    patientHomeScreen.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    new ProjectLoginScreen().show();
  }
}
