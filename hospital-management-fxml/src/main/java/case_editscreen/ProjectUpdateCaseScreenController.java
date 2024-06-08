package case_editscreen;

import admin_home_screen.ProjectHomeScreen;
import appointment_home_screen.AppointmentHomeScreen;
import case_home_screen.CaseHomeScreen;
import common.RestUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.dnyanyog.dto.CaseRequest;
import org.dnyanyog.dto.CaseResponse;
import patient_home_screen.PatientHomeScreen;
import projectlogin.ProjectLoginScreen;
import user_home_screen.UserHomeScreen;

public class ProjectUpdateCaseScreenController {

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

  @FXML private Button Cancel;

  @FXML private Button Update;

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
    CaseHomeScreen caseHomeScreen = new CaseHomeScreen();
    caseHomeScreen.show();
  }

  public void Update(ActionEvent event) throws Exception {
    CaseRequest updateCase = new CaseRequest();
    updateCase.setCase_number(Case_number.getText());
    updateCase.setExamination_date(Examination_date.getText().toString());
    updateCase.setPatientName(PatientName.getText());
    updateCase.setPrescription(Prescription.getText());
    updateCase.setSymptoms(Symptoms.getText());
    updateCase.generatePatientId();
    updateCase.generateCaseId();

    String case_id = CaseId.getText();
    CaseResponse response =
        RestUtil.sendPostRequest(
            "http://localhost:8083/api/v1/case/" + case_id, CaseResponse.class, updateCase);
    System.out.println("Case updated successfully");
  }

  public void Cancel(ActionEvent event) throws Exception {
    CaseHomeScreen caseHomeScreen = new CaseHomeScreen();
    caseHomeScreen.show();
  }

  public void Logout(ActionEvent event) throws Exception {
    new ProjectLoginScreen().show();
  }
}
