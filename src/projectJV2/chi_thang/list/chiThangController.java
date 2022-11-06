package projectJV2.chi_thang.list;

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
import library.entities.Book;
import projectJV2.Main;
import projectJV2.dao.impls.chiThangRepository;
import projectJV2.entities.chiThang;
import projectJV2.enums.RepoType;
import projectJV2.factory.RepositoryFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class chiThangController implements Initializable {

    public TableView<chiThang> tbChiThang;
    public TableColumn<chiThang,Integer> tdId;
    public TableColumn<chiThang,String> tdSName;
    public TableColumn<chiThang,Integer> tdPrice;
    public TableColumn<chiThang, Date> tdDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<chiThang,Integer>("id"));
        tdSName.setCellValueFactory(new PropertyValueFactory<chiThang,String>("sname"));
        tdPrice.setCellValueFactory(new PropertyValueFactory<chiThang,Integer>("spending"));
        tdDate.setCellValueFactory(new PropertyValueFactory<chiThang,Date>("date"));

        ObservableList<chiThang> ls = FXCollections.observableArrayList();
        chiThangRepository rp = (chiThangRepository) RepositoryFactory.createRepository(RepoType.CHITHANG);
        ls.addAll(rp.all());
        tbChiThang.setItems(ls);
    }

    public void backToHome2(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/Home.fxml"));
        Main.rootStage.setTitle("Quản Lý Chi Tieu");
        Main.rootStage.setScene(new Scene(listChi,600,400));
    }

    public void addChiThang(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/them_chi/themchithang/themchithang.fxml"));
        Main.rootStage.setTitle("Thêm Khoản Chi");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }
}
