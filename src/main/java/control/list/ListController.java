package control.list;

import com.jfoenix.controls.JFXListView;
import database.DataManagement;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Account;

public class ListController implements Initializable {

  @FXML
  private JFXListView accountsList;
  private List<Account> accounts;
  private ObservableList<Account> observableList =FXCollections.observableArrayList();

  @FXML
  public void initialize(URL location, ResourceBundle resources) {
    System.out.println("Started");
    this.accounts = DataManagement.getInstance().retrieveAll();
    System.out.println("Done");
    this.observableList.setAll(this.accounts);

    System.out.println("Accounts outside: " + accounts);

    System.out.println(this.observableList);
    this.accountsList.setItems(this.observableList);
    this.accountsList.setCellFactory(param -> new AccountCell());
  }
}
