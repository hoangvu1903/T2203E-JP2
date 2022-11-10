package exam.student.create;

import exam.dao.impls.StudentRepository;
import exam.entities.student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import exam.Main;
import javafx.scene.control.TextField;


public class createStudentController {

    public TextField txtName;
    public TextField txtAddress;
    public TextField txtPhone;

    public void goToHome(ActionEvent actionEvent) throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String address = txtAddress.getText();
            String phone = txtPhone.getText();
            student student = new student(null,name,address,phone);
            StudentRepository rp = new StudentRepository();
            if(rp.create(student)){
                backToList();
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void backToList() throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("../list/listStudent.fxml"));
        Main.rootStage.setTitle("List Student");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }
}
