package library.Student.create;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import library.Main;
import library.helper.Connector;

import java.util.ArrayList;

public class StudentCreateController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;


    public void submit(ActionEvent actionEvent) {
        try {
            Integer id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            String email = txtEmail.getText();
            Integer tel = Integer.parseInt(txtTel.getText());
            String sql_txt = "insert in to students(id,name,email,tel) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList ar = new ArrayList();
            ar.add(id);
            ar.add(name);
            ar.add(email);
            ar.add(tel);
            if (conn.execute(sql_txt,ar)){
                backToList();
            }else {
                System.out.println("errors");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backToList() throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("../list/listStudent.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }
}
