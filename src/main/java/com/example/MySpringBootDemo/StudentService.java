package com.example.MySpringBootDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findAll(int limit) {
		
		if(limit == 0) {
			return this.studentRepository.findAll();
		}
		else {
		return this.studentRepository.findByLimit(limit);
		}
		
	}

	public Student saveStudent(StudentDTO studentDTO) {
		Student student = this.studentRepository.findByName(studentDTO.getName()).orElse(null);
//		Student studnet = this.studentRepository.findByName(studentDTO.getName())
//				.orElseThrow(()->new CustomError(404,"Stdent does not exist"));
		if(student ==null) {
		student = new Student();
		student.setName(studentDTO.getName());
		student.setMarks(studentDTO.getMarks());
		this.studentRepository.save(student);
		//return the saved student as an acknowledgement
		return student;
		}
		throw new CustomError(406,"Student already exists");
		
		
		
		
	}

	public Student updateStudent(StudentDTO studentDTO, long id) {
		Student student = this.studentRepository.findById(id)
				.orElseThrow(()->new CustomError(404,"Student not found"));
		student.setName(studentDTO.getName());
		student.setMarks(studentDTO.getMarks());
		//JPA automatically updates the student if exists or else creates new object 
		return this.studentRepository.save(student);
		
		
	}

	public Student deleteStudent(long id) {
		Student student = this.studentRepository.findById(id).
				orElseThrow(()->new CustomError(404,"Student not found"));
		
		this.studentRepository.delete(student);
		return student;
	}
	
	
	
	

}
