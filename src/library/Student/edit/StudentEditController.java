package library.Student.edit;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import library.dao.impls.BookRepository;
import library.dao.impls.StudentRepository;
import library.entities.Book;
import library.entities.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentEditController implements Initializable {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    public static Student editedStudent;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (editedStudent != null){
            txtName.setText(editedStudent.getName());
            txtEmail.setText(editedStudent.getEmail());
            txtTel.setText(editedStudent.getTel().toString());
        }

    }

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            Integer tel = Integer.parseInt(txtTel.getText());
            editedStudent.setName(name);
            editedStudent.setEmail(email);
            editedStudent.setTel(tel);
            StudentRepository rp = new StudentRepository();
            if(rp.update(editedStudent)){
                backToList(null);
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backToList(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }
}
