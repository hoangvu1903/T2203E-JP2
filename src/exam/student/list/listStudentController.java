package exam.student.list;

import exam.Main;
import exam.dao.impls.StudentRepository;
import exam.entities.student;
import exam.enums.RepoType;
import exam.factory.RepositoryFactory;
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

import java.net.URL;
import java.util.ResourceBundle;

public class listStudentController implements Initializable {


    public TableColumn<student,Integer> tdId;
    public TableColumn<student,String> tdName;
    public TableColumn<student,String> tdAddress;
    public TableColumn<student,String> tdPhone;
    public TableView<student> tbStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<student,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<student,String>("name"));
        tdAddress.setCellValueFactory(new PropertyValueFactory<student,String>("address"));
        tdPhone.setCellValueFactory(new PropertyValueFactory<student,String>("phone"));

        ObservableList<student> ls = FXCollections.observableArrayList();
        StudentRepository rp = (StudentRepository) RepositoryFactory.createRepository(RepoType.STUDENT);
        ls.addAll(rp.all());
        tbStudent.setItems(ls);
    }

    public void goToHome(ActionEvent actionEvent) throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }
    public void goToCreateStudent(ActionEvent actionEvent) throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("../create/createStudent.fxml"));
        Main.rootStage.setTitle("Add Student");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }
}
