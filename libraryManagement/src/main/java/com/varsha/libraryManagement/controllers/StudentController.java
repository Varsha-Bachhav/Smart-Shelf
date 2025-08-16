package com.varsha.libraryManagement.controllers;

import com.varsha.libraryManagement.dto.AddStudentDtoRequest;
import com.varsha.libraryManagement.dto.StudentDto;
import com.varsha.libraryManagement.repository.StudentRepository;
import com.varsha.libraryManagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/demo")
    public String demo(){
        return "Hello Varsha";
    }

    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(1,"Varsha","varsha@gmail.com","7757801496","CS",2025,"Junibej");
    }

    @GetMapping("/getAllStudents")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getAllStudents/{id}")
    public StudentDto getStudent(@PathVariable Long id)
    {
        return studentService.getStudent(id);
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentDtoRequest addStudentDtoRequest)
    {
        StudentDto studentDto = studentService.createNewStudent(addStudentDtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id)
    {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<AddStudentDtoRequest> updateStudent(@PathVariable Long id,
                                                              @RequestBody AddStudentDtoRequest addStudentDtoRequest)
    {
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentDtoRequest));
    }
}