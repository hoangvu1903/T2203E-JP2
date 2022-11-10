package exam.dao.impls;

import exam.dao.interfaces.IRepository;
import exam.entities.student;
import exam.helper.Connector;
import exam.entities.student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements IRepository<student> {
    @Override
    public ArrayList<student> all() {
        ArrayList<student> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from students";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                student st = new student(id,name,address,phone);
                ls.add(st);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;

    }

    @Override
    public boolean create(student student) {
        try {
            String sql_txt = "insert into students(name,address,phone) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getName());
            arr.add(student.getPhone());
            arr.add(student.getId());
            if(conn.execute(sql_txt,arr)) {
                return true;
            }
        }catch (Exception e){

        }

        return false;
    }

    @Override
    public boolean update(student student) {
        try {
            String sql_txt = "update students set name=?, address=?,phone=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getName());
            arr.add(student.getAddress());
            arr.add(student.getPhone());
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
    public boolean delete(student student) {
        try {
            String sql_txt = "delete from students where id=? ";
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
    public student findOne(Integer id) {
        try {
            String sql_txt = "select * from students where id=? ";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                return new student(id,name,address,phone);

            }

        }catch (Exception e){

        }
        return null;
    }
}
