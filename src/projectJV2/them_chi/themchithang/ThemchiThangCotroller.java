package projectJV2.them_chi.themchithang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import projectJV2.Main;
import projectJV2.dao.impls.TVRepository;
import projectJV2.dao.impls.chiThangRepository;
import projectJV2.entities.ThanhVien;
import projectJV2.entities.chiThang;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ThemchiThangCotroller implements Initializable {
    public TextField txtSName;
    public TextField txtSpend;
    public TextField txtDate;
    public ComboBox<ThanhVien> cbMember;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TVRepository rp = new TVRepository();
        ObservableList<ThanhVien> ls = FXCollections.observableArrayList();
        ls.addAll(rp.all());
        cbMember.setItems(ls);
    }

    public void backToChiThang() throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/chi_thang/list/chithang.fxml"));
        Main.rootStage.setTitle("Chi Tháng");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }

    public void Submit(ActionEvent actionEvent) {
        try {
            ThanhVien selected = cbMember.getSelectionModel().getSelectedItem();
            String sname = txtSName.getText();
            Integer spend = Integer.parseInt(txtSpend.getText());
            String date = txtDate.getText();
            chiThang chiThang = new chiThang(null,sname,spend,date);
            chiThangRepository rp = new chiThangRepository();
            if (rp.create(chiThang)){
                backToChiThang();
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
