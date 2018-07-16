package control.list;

import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Account;

import java.io.IOException;

public class AccountCell extends JFXListCell<Account>
{
    @FXML
    private ImageView image;
    @FXML
    private VBox vBox;
    @FXML
    private Label username;
    @FXML
    private Label company;

    private FXMLLoader fxmlLoader;
    public AccountCell()
    {
        loadFXML();
    }

    private void loadFXML()
    {

        this.fxmlLoader = new FXMLLoader(getClass().getResource("/view/Cell.fxml"));
        try
        {
            this.fxmlLoader.setController(this);
            this.fxmlLoader.load();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void updateItem(Account item, boolean empty)
    {
        super.updateItem(item, empty);
        if(empty)
        {
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }
        else {
           this.username.setText(item.getUsername());
           this.company.setText(item.getCompany());
           setGraphic(this.vBox);
           setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }
}
