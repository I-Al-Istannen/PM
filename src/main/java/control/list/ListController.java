package control.list;

import com.jfoenix.controls.JFXListView;
import database.DataManagement;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import model.Account;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListController
{
    @FXML
    private JFXListView accountsList;
    private List<Account> accounts;
    private ObservableList<Account> observableList;

    @FXML
    public void initialize(URL location, ResourceBundle resources)
    {
        this.accounts = DataManagement.getInstance().retrieveAll();
        this.observableList.setAll(this.accounts);
        this.accountsList.setItems(this.observableList);
        this.accountsList.setCellFactory(new AccountCellFactory());
    }
}
