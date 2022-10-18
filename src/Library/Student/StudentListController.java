package Library.Student;

import Library.entities.Student;
import Library.entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Library.Student.StudentListController;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student,Integer> tdId;
    public TableColumn<Student,String> tdName;
    public TableColumn<Student,String> tdEmail;
    public TableColumn<Student,Integer> tdTel;

    public final static String connectionString = "jdbc:mysql://localhost:3306/t2203e";

    public final static String user = "root";

    public final static String pwd = "root";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tdEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        tdTel.setCellValueFactory(new PropertyValueFactory<Student,Integer>("tel"));

        ObservableList<Student> lss = FXCollections.observableArrayList();

        // lay data from database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement statement = conn.createStatement();
            String sql_txt = "select * from books";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int tel = rs.getInt("tel");
                Student s = new Student(id,name,email,tel);
                lss.add(s);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudents.setItems(lss);
        }
    }
}
