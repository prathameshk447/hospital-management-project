package patient_editscreen;

import admin_home_screen.ProjectHomeScreen;
import appointment_home_screen.AppointmentHomeScreen;
import case_home_screen.CaseHomeScreen;
import common.RestUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.dnyanyog.dto.PatientRequest;
import org.dnyanyog.dto.PatientResponse;
import patient_home_screen.PatientHomeScreen;
import projectlogin.ProjectLoginScreen;
import user_home_screen.UserHomeScreen;

public class ProjectEditPatientScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Patients;

  @FXML private Button Cases;

  @FXML private Button Appointments;

  @FXML private Button Users;

  @FXML private TextField PatientName;

  @FXML private TextField Patientnamemarathi;

  @FXML private TextField Mobile;

  @FXML private TextField Gender;

  @FXML private TextField Birth_date;

  @FXML private TextField First_examination_date;

  @FXML private TextField Address;

  @FXML private TextField PatientId;

  @FXML private Button Cancel;

  @FXML private Button Save;

  @FXML private Button Logout;

  @FXML private Button Update;

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
    PatientRequest updatePatient = new PatientRequest();
    updatePatient.setAddress(Address.getText());
    updatePatient.setMobile(Mobile.getText());
    updatePatient.setPatientnamemarathi(Patientnamemarathi.getText());
    updatePatient.setPatientName(PatientName.getText());
    updatePatient.setBirth_date(Birth_date.getText());
    updatePatient.setFirst_examination_date(First_examination_date.getText());
    updatePatient.setGender(Gender.getText());
    updatePatient.generatePatientId();

    String patient_id = PatientId.getText();
    PatientResponse response =
        RestUtil.sendPostRequest(
            "http://localhost:8082/api/v1/patient/" + patient_id,
            PatientResponse.class,
            updatePatient);
    System.out.println("Patient updated successfully");
  }

  public void Cancel(ActionEvent event) throws Exception {
    PatientHomeScreen patientHomeScreen = new PatientHomeScreen();
    patientHomeScreen.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    new ProjectLoginScreen().show();
  }
}
