package Assignment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import Assignment1.Main;


import java.awt.print.Book;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  {
    public ListView<Book> lv;

    public static ObservableList<Book> list = FXCollections.observableArrayList();
    public static Book editItem;

    public void initialize(URL location, ResourceBundle resources) {
//        list.add(new Subject("JP1","Java Programing 1",40));
//        list.add(new Subject("JP2","Java Programing 2",40));
        lv.setItems(list);
    }

    public void goToForm(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("themmoiDS.fxml"));
        Scene listScene = new Scene(listPage,800,600);

        Main.rootStage.setTitle("Thêm sách");
        Main.rootStage.setScene(listScene);
    }

    public void edit(ActionEvent actionEvent) throws Exception{
        editItem = lv.getSelectionModel().getSelectedItem();
        if(editItem == null) return;
        Parent listPage = FXMLLoader.load(getClass().getResource(".fxml"));
        Scene listScene = new Scene(listPage,800,600);

        Main.rootStage.setTitle("Sửa môn học");
        Main.rootStage.setScene(listScene);
    }
}
