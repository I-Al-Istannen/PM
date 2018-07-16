package view;

import database.DataManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class View extends Application {

  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(View.class);
    logger.info("Booting up the program");
    DataManagement dataManagement = DataManagement.getInstance();
    dataManagement.retrieveAll();
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/view/structure.fxml"));
    Scene scene = new Scene(root, 600, 600);
    stage.setTitle("Password Manager");
    stage.setScene(scene);
    stage.show();
  }


}
