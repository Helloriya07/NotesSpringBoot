package com.example.MySpringBootDemo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
	
	private StudentService studentService;
	
	@GetMapping
	@JsonView(MyViews.AdminView.class)
	public ResponseEntity<?> getStudents(@RequestParam(name = "limit" , defaultValue="0") int limit){
		List<Student> students = this.studentService.findAll(limit);
		return ResponseEntity.ok(students);
		
	}
	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO){
		Student student = this.studentService.saveStudent(studentDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);

	
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO,@PathVariable("id") long id){
		Student student = this.studentService.updateStudent(studentDTO,id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(student);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") long id){
		Student student = this.studentService.deleteStudent(id);
		return ResponseEntity.ok(student);
	}
	
	

}
