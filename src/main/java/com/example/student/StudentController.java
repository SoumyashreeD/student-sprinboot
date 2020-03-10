package com.example.student;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ApiResponse<Student> saveStudent(@RequestBody Studentdto student){
        return new ApiResponse<>(HttpStatus.OK.value(), "Student saved successfully.",studentService.save(student));
    }

    @GetMapping
    public ApiResponse<List<Student>> listStudent(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Student list fetched successfully.",studentService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Student> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "Student fetched successfully.",studentService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<Studentdto> update(@RequestBody Studentdto studentdto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",studentService.update(studentdto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
    	studentService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}
