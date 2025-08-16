package com.varsha.libraryManagement.service;

import com.varsha.libraryManagement.dto.AddStudentDtoRequest;
import com.varsha.libraryManagement.dto.StudentDto;
import com.varsha.libraryManagement.entity.Student;
import com.varsha.libraryManagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = students.stream().map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail(),student.getPhNumber(),student.getDepartment(),student.getYear(), student.getAddress())).toList();
        return studentDtoList;
    }

    public StudentDto getStudent(Long id) {
        Student std = studentRepository.getReferenceById(id);
        StudentDto studentDto = new StudentDto(std.getId(),std.getName(),std.getEmail(),std.getPhNumber(),std.getDepartment(),std.getYear(),std.getAddress());
        return studentDto;
    }

    public StudentDto createNewStudent(AddStudentDtoRequest addStudentDtoRequest)
    {
        Student newStudent = new Student();
        newStudent.setName(addStudentDtoRequest.getName());
        newStudent.setDepartment(addStudentDtoRequest.getDepartment());
        newStudent.setAddress(addStudentDtoRequest.getAddress());
        newStudent.setEmail(addStudentDtoRequest.getEmail());
        newStudent.setYear(addStudentDtoRequest.getYear());
        newStudent.setPhNumber(addStudentDtoRequest.getPhNumber());

        studentRepository.save(newStudent);

        StudentDto studentDto = new StudentDto();
        studentDto.setName(newStudent.getName());
        studentDto.setDepartment(newStudent.getDepartment());
        studentDto.setAddress(newStudent.getAddress());
        studentDto.setEmail(newStudent.getEmail());
        studentDto.setYear(newStudent.getYear());
        studentDto.setPhNumber(newStudent.getPhNumber());

        return studentDto;
    }

    public void deleteStudentById(Long id) {
        if(studentRepository.existsById(id))
        {
            studentRepository.deleteById(id);
        }
        else{
            throw new IllegalArgumentException("Student does not exist by id "+id);
        }
    }

    public AddStudentDtoRequest updateStudent(Long id, AddStudentDtoRequest addStudentDtoRequest) {
        Student std = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found"));
        std.setPhNumber(addStudentDtoRequest.getPhNumber());
        std.setName(addStudentDtoRequest.getName());
        std.setYear(addStudentDtoRequest.getYear());
        std.setAddress(addStudentDtoRequest.getAddress());
        std.setEmail(addStudentDtoRequest.getEmail());
        std.setDepartment(addStudentDtoRequest.getDepartment());

        std = studentRepository.save(std);
        addStudentDtoRequest.setAddress(std.getAddress());
        addStudentDtoRequest.setYear(std.getYear());
        addStudentDtoRequest.setName(std.getName());
        addStudentDtoRequest.setEmail(std.getEmail());
        addStudentDtoRequest.setPhNumber(std.getPhNumber());
        addStudentDtoRequest.setDepartment(std.getDepartment());
        return addStudentDtoRequest;

    }
}
