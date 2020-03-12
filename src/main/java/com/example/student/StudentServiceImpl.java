package com.example.student;



import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	public List<Student> findAll() {
		List<Student> list = new ArrayList<>();
		studentDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		studentDao.deleteById(id);
	}

	@Override
	public Student findOne(String username) {
		return studentDao.findByUsername(username);
	}

	@Override
	public Student findById(int id) {
		Optional<Student> optionalUser =studentDao.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

    @Override
    public Studentdto update(Studentdto studentdto) {
    	Student student = findById(studentdto.getId());
        if(student != null) {
            BeanUtils.copyProperties(studentdto, student, "password", "username");
            studentDao.save(student);
        }
        return studentdto;
    }

    public Student save(Studentdto student) {
    	Student newStudent = new Student();
    	newStudent.setUsername(student.getUsername());
    	newStudent.setFirstName(student.getFirstName());
    	newStudent.setLastName(student.getLastName());
    	newStudent.setPassword(student.getPassword());
    	newStudent.setAge(student.getAge());
	    newStudent.setGender(student.getGender());
    	newStudent.setPercentage(student.getPercentage());
        return studentDao.save(newStudent);
    }
}
