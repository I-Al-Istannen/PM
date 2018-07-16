package control.list;

import com.jfoenix.controls.JFXListCell;
import javafx.scene.control.ContentDisplay;
import model.Account;

public class AccountCell extends JFXListCell<Account> {

  private AccountCellItem display;

  public AccountCell() {
    display = new AccountCellItem();
  }

  @Override
  protected void updateItem(Account item, boolean empty) {
    super.updateItem(item, empty);

    if (empty) {
      setContentDisplay(ContentDisplay.TEXT_ONLY);
    } else {
      display.setName(item.getUsername());
      display.setCompany(item.getCompany());
      setGraphic(display);
      setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }
  }
}
