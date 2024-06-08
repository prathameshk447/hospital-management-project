package projectlogin;

import admin_home_screen.ProjectHomeScreen;
import common.RestUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;

public class ProjectLoginScreenController {

  @FXML private TextField MobileNumber;

  @FXML private TextField Password;

  @FXML private Button Login;

  public void projectlogin(ActionEvent event) throws Exception {
    boolean loginStatus =
        ProjectLoginScreenController.validateMobileandPassword(
            MobileNumber.getText(), Password.getText());

    if (loginStatus == true) {
      ProjectHomeScreen projectHomeScreen = new ProjectHomeScreen();
      projectHomeScreen.show();

    } else {
      System.out.println("Login Unsuccessfully!!");
    }
  }

  public static boolean validateMobileandPassword(String MobileNumber, String Password) {
    LoginRequest loginRequest = new LoginRequest();

    loginRequest.setMobileNumber(MobileNumber);
    loginRequest.setPassword(Password);

    LoginResponse response;

    try {
      response =
          RestUtil.sendPostRequest(
              "http://localhost:8081/api/v1/directory/validate", LoginResponse.class, loginRequest);

      if (response.getStatus().equals("Success")) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}
