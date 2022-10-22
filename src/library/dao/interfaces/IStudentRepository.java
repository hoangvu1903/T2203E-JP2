package library.dao.interfaces;

import library.entities.Book;
import library.entities.Student;

import java.util.ArrayList;

public interface IStudentRepository {
    ArrayList<Student> all();
    boolean create(Student student);
    boolean update(Student student);
    boolean delete(Student student);

    Student findOne(Integer id);
}
