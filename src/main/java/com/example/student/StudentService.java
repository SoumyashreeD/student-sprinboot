package com.example.student;




import java.util.List;

public interface StudentService {

    Student save(Studentdto student);
    List<Student> findAll();
    void delete(int id);

    Student findOne(String username);

    Student findById(int id);

    Studentdto update(Studentdto studentdto);
}
