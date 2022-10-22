package library.Student.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.dao.impls.StudentRepository;
import library.entities.Book;
import library.entities.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {

    public TableView<Student> tbStudents;
    public TableColumn<Student,Integer> tdId;
    public TableColumn<Student,String> tdName;
    public TableColumn<Student,String> tdEmail;
    public TableColumn<Student,Integer> tdTel;
    public TableColumn<Book,Button> tdEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new  PropertyValueFactory<Student,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tdEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        tdTel.setCellValueFactory(new PropertyValueFactory<Student,Integer>("tel"));
        tdEdit.setCellValueFactory(new PropertyValueFactory<Book, Button>("edit"));

        ObservableList<Student> ls = FXCollections.observableArrayList();
        StudentRepository rp = new StudentRepository();
        ls.addAll(rp.all());
        tbStudents.setItems(ls);
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
