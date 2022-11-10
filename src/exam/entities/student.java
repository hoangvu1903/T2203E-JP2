package exam.entities;

import exam.dao.impls.StudentRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import exam.Main;
import exam.student.edit.editController;

public class student {
    public Integer id;
    public String name;
    public String address;
    public String phone;
    public Button edit;

    public student() {

    }

    public student(Integer id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) -> {
            try {
                editController.editedStudent = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../book/edit/edit.fxml"));
                Main.rootStage.setScene(new Scene(edit,800,600));
            }catch (Exception e){

            }

        });


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
