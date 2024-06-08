package case_searchscreen;

import admin_home_screen.ProjectHomeScreen;
import appointment_home_screen.AppointmentHomeScreen;
import case_home_screen.CaseHomeScreen;
import common.RestUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.dnyanyog.dto.CaseResponse;
import patient_home_screen.PatientHomeScreen;
import projectlogin.ProjectLoginScreen;
import user_home_screen.UserHomeScreen;

public class ProjectSearchCaseScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Patients;

  @FXML private Button Cases;

  @FXML private Button Appointments;

  @FXML private Button Users;

  @FXML private TextField PatientName;

  @FXML private TextField Case_number;

  @FXML private TextField Examination_date;

  @FXML private TextField Symptoms;

  @FXML private TextField Prescription;

  @FXML private TextField CaseId;

  @FXML private TextField PatientId;

  @FXML private Button Cancel;

  @FXML private Button Save;

  @FXML private Button Logout;

  @FXML private Button SearchByCase;

  @FXML private Button SearchByPatient;

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

  public void SearchByCase(ActionEvent event) throws Exception {
    String case_id = CaseId.getText().trim();

    CaseResponse response = null;

    response =
        RestUtil.sendGetRequest("http://localhost:8083/api/v1/case/" + case_id, CaseResponse.class);

    PatientName.setText(response.getPatientName());

    Case_number.setText(response.getCase_number());
    Examination_date.setText(response.getExamination_date());
    Symptoms.setText(response.getSymptoms());
    Prescription.setText(response.getPrescription());
    CaseId.setText(response.getCaseId());
  }

  public void SearchByPatient(ActionEvent event) throws Exception {
    String patient_id = PatientId.getText().trim();

    CaseResponse response = null;

    response =
        RestUtil.sendGetRequest(
            "http://localhost:8083/api/v1/case/" + patient_id, CaseResponse.class);

    PatientName.setText(response.getPatientName());

    Case_number.setText(response.getCase_number());
    Examination_date.setText(response.getExamination_date());
    Symptoms.setText(response.getSymptoms());
    Prescription.setText(response.getPrescription());
    CaseId.setText(response.getCaseId());
  }

  public void Save(ActionEvent event) throws Exception {}

  public void Cancel(ActionEvent event) throws Exception {
    CaseHomeScreen caseHomeScreen = new CaseHomeScreen();
    caseHomeScreen.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    new ProjectLoginScreen().show();
  }
}
