package library.Student.create;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentCreateController implements Initializable {

    public TextField txtId;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void submit(ActionEvent actionEvent) {
    }

    public void backToList(ActionEvent actionEvent) {
    }
}
