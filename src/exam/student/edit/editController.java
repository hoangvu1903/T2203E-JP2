package exam.student.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import exam.Main;
import exam.dao.impls.StudentRepository;
import exam.entities.student;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class editController implements Initializable {
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtPhone;

    public static student editedStudent; // khi nhan nut edit thi se dung bien nay la dang dung dòng b nhấn sửa

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (editedStudent != null) {
            txtName.setText(editedStudent.getName());
            txtAddress.setText(editedStudent.getAddress());
            txtPhone.setText(editedStudent.getPhone());
        }
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String address = txtAddress.getText();
            String phone = txtPhone.getText();
            editedStudent.setName(name);
            editedStudent.setAddress(address);
            editedStudent.setPhone(phone);
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

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void delete(ActionEvent actionEvent) {
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete student");
            alert.setHeaderText("Are you sure delete student: "+editedStudent.getName() );
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == ButtonType.OK) {


                StudentRepository rp = new StudentRepository();
                if (rp.delete(editedStudent)) {
                    backToList(null);
                } else {
                    System.out.println("error");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
