package control.list;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AccountCellItem extends BorderPane {

  @FXML
  private ImageView image;
  @FXML
  private VBox vBox;
  @FXML
  private Label username;
  @FXML
  private Label company;

  public AccountCellItem() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Cell.fxml"));
    fxmlLoader.setController(this);
    fxmlLoader.setRoot(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setName(String name) {
    username.setText(name);
  }
  public void setCompany(String Company) {
    company.setText(Company);
  }
}
