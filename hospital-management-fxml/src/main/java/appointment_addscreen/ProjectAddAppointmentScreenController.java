package appointment_addscreen;

import admin_home_screen.ProjectHomeScreen;
import appointment_home_screen.AppointmentHomeScreen;
import case_home_screen.CaseHomeScreen;
import common.RestUtil;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.dnyanyog.dto.AppointmentRequest;
import org.dnyanyog.dto.AppointmentResponse;
import patient_home_screen.PatientHomeScreen;
import projectlogin.ProjectLoginScreen;
import user_home_screen.UserHomeScreen;

public class ProjectAddAppointmentScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Patients;

  @FXML private Button Cases;

  @FXML private Button Appointments;

  @FXML private Button Users;

  @FXML private TextField PatientName;

  @FXML private TextField Appointment_time;

  @FXML private TextField Examination_date;

  @FXML private Button Cancel;

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

  public void Save(ActionEvent event) throws Exception {

    AppointmentRequest addAppointment = new AppointmentRequest();

    addAppointment.setPatientName(PatientName.getText());
    addAppointment.setAppointment_time(Appointment_time.getText());
    addAppointment.setExamination_date(Examination_date.getText());

    try {
      AppointmentResponse response =
          RestUtil.sendPostRequest(
              "http://localhost:8084/api/v1/appointment/add",
              AppointmentResponse.class,
              addAppointment);
      System.out.println("User Added Successfully");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void Cancel(ActionEvent event) throws Exception {
    AppointmentHomeScreen appointmentHomeScreen = new AppointmentHomeScreen();
    appointmentHomeScreen.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    new ProjectLoginScreen().show();
  }
}
