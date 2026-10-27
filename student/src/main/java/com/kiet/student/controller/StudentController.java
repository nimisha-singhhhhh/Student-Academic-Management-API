
        package com.kiet.student.controller;
import com.kiet.student.model.Student;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.stream.Collectors;
@RestController
public class StudentController {
        private List<Student> students = new ArrayList<>(List.of(
                new Student(101, "Rahul Sharma", "rahul@kiet.edu", "CSE", 2, 8.65),
                new Student(102, "Priya Sharma", "priya@kiet.edu", "CSE", 2, 9.10),
                new Student(103, "Amit Kumar", "amit@kiet.edu", "ECE", 3, 8.20),
                new Student(104, "Neha Singh", "neha@kiet.edu", "CSE", 2, 9.30),
                new Student(105, "Rohit Verma", "rohit@kiet.edu", "IT", 1, 7.90)
        ));

        @GetMapping("/")
        public String home() {
                return "Student Management System is Running!";
        }

        @GetMapping("/students")

        public List<Student> getAllStudent() {
                return students;
        }
        @GetMapping("/students/{id}")
        public Student getStudentById(@PathVariable int id) {

                for (Student student : students) {
                        if (student.getStudentId() == id) {
                                return student;
                        }
                }

                return null;
        }

        @PostMapping("/students")
        public Student addStudent(@RequestBody Student student) {


                students.add(student);
                return student;
        }
        @PutMapping("/students/{studentId}")
        public Student updateStudent(@PathVariable int studentId,
                                     @RequestBody Student updatedStudent) {

                for (Student student : students) {
                        if (student.getStudentId() == studentId) {
                                student.setName(updatedStudent.getName());
                                student.setEmail(updatedStudent.getEmail());
                                student.setBranch(updatedStudent.getBranch());
                                student.setYear(updatedStudent.getYear());
                                student.setCgpa(updatedStudent.getCgpa());

                                return student;
                        }
                }

                return null;
        }
        @DeleteMapping("/students/{studentId}")
        public String deleteStudent(@PathVariable int studentId) {

                for (Student student : students) {
                        if (student.getStudentId() == studentId) {
                                students.remove(student);
                                return "Student deleted successfully!";
                        }
                }

                return "Student not found!";
        }
        @GetMapping("/students/search")
        public List<Student> searchStudents(
                @RequestParam String branch,
                @RequestParam int year) {

                return students.stream()
                        .filter(s -> s.getBranch().equalsIgnoreCase(branch)
                                && s.getYear() == year)
                        .collect(Collectors.toList());
        }
        @GetMapping("/students/topper")
        public List<Student> getToppers(@RequestParam double cgpa) {

                return students.stream()
                        .filter(s -> s.getCgpa() >= cgpa)
                        .collect(Collectors.toList());
        }

}

