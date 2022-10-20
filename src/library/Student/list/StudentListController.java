package library.Student.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.entities.Book;
import library.entities.Student;
import library.helper.Connector;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student,Integer> txId;
    public TableColumn<Student,String> txName;
    public TableColumn<Student,String> txEmail;
    public TableColumn<Student,Integer> txTel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        txName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        txEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        txTel.setCellValueFactory(new PropertyValueFactory<Student,Integer>("tel"));

        ObservableList<Student> ls = FXCollections.observableArrayList();

        // lay dât from database
        try {
            String sql_txt = "select * from students";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int tel = rs.getInt("tel");
                Student s = new Student(id,name,email,tel);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            tbStudents.setItems(ls);
        }

    }

    public void createNewStudent(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../create/createStudent.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void Back(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
