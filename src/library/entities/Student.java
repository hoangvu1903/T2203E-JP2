package library.entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import library.Main;
import library.Student.edit.StudentEditController;

public class Student {
    public Integer id;
    public String name;
    public  String email;
    public Integer tel;
    public Button edit;

    public Student() {

    }
    public Student(Integer id, String name, String email, Integer tel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.edit = new Button("Edit"); // dinh nghia du lieu 1 nut
        this.edit.setOnAction((event) ->{
            try {
                StudentEditController.editedStudent = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../Student/edit/StudentEdit.fxml"));
                Main.rootStage.setScene(new Scene(edit,800,600));

            }catch (Exception e) {

            }
        } );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
    public String toString() {
        return getName();
    }
}
