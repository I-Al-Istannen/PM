package control.list;

import com.jfoenix.controls.JFXListView;
import database.DataManagement;
import javafx.scene.control.ListCell;
import javafx.util.Callback;
import model.Account;

public class AccountCellFactory implements Callback<JFXListView<Account>, ListCell<Account>>
{

    @Override
    public ListCell<Account> call(JFXListView<Account> param)
    {
        return new AccountCell();
    }
}
