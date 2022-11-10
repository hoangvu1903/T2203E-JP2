package exam;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class homeController {
    public void goToCreateStudent(ActionEvent actionEvent) throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("student/create/createStudent.fxml"));
        Main.rootStage.setTitle("Add Student");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }

    public void goToListStudent(ActionEvent actionEvent) throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("student/list/listStudent.fxml"));
        Main.rootStage.setTitle("List Student");
        Main.rootStage.setScene(new Scene(listStudent,800,600));
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}
