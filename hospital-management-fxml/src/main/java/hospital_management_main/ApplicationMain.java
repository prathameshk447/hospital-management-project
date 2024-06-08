package hospital_management_main;

import common.StageFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import projectlogin.ProjectLoginScreen;

public class ApplicationMain extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    StageFactory.stage = stage;

    new ProjectLoginScreen().show();
  }
}
