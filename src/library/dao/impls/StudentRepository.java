package library.dao.impls;

import library.dao.interfaces.IBookRepository;
import library.dao.interfaces.IStudentRepository;
import library.entities.Book;
import library.entities.Student;
import library.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements IStudentRepository {

    public ArrayList<Student> all() {
        ArrayList<Student> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from books";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int tel = rs.getInt("tel");
                Student s = new Student(id,name,email,tel);
                ls.add(s);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(Student student) {
        try {
            String sql_txt = "insert into students(name,email,tel) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getName());
            arr.add(student.getEmail());
            arr.add(student.getTel());
            if(conn.execute(sql_txt,arr)) {
                return true;
            }
        }catch (Exception e){

        }

        return false;
    }

    @Override
    public boolean update(Student student)  {
        try {
            String sql_txt = "update students set name=?, email=?,tel=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getName());
            arr.add(student.getEmail());
            arr.add(student.getTel());
            arr.add(student.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        try {
            String sql_txt = "delete from books where id=? ";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getId());
            if(conn.execute(sql_txt,arr)) {
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public Student findOne(Integer id) {
        try {
            String sql_txt = "select * from books where id=? ";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int tel = rs.getInt("tel");
                return new Student(id,name,email,tel);

            }

        }catch (Exception e){

        }
        return null;
    }



}
