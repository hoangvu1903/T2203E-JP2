package exam.dao.interfaces;

import exam.entities.student;

import java.util.ArrayList;

public interface IStudentRepository {
    ArrayList<student> all();
    boolean create(student student);
    boolean update(student student);
    boolean delete(student student);

    student findOne(Integer id);
}
