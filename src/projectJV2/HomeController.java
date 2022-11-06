package projectJV2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.InputMethodEvent;

public class HomeController {

    public void goToThuThang(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("thu_thang/list/thuthang.fxml"));
        Main.rootStage.setTitle("Thu Tháng");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }

    public void goToChiThang(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("chi_thang/list/chithang.fxml"));
        Main.rootStage.setTitle("Chi Tháng");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }

    public void goToThuNam(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("thu_nam/list/thunam.fxml"));
        Main.rootStage.setTitle("Thu Năm");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }


    public void goToChiNam(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("chi_nam/list/chinam.fxml"));
        Main.rootStage.setTitle("Chi Năm");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }

    public void goToThanhVien(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("thanh_vien/list/thanhvien.fxml"));
        Main.rootStage.setTitle("Thành Viên");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }

    public void goToThemChi(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("them_chi/themchithang/themchithang.fxml"));
        Main.rootStage.setTitle("Thêm Khoản Chi");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }

    public void goToThemThu(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("them_thu/themthu.fxml"));
        Main.rootStage.setTitle("Thêm Khoản Thu");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }
}
