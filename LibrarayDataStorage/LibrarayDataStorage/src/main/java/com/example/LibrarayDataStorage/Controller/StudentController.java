package com.example.LibrarayDataStorage.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibrarayDataStorage.Entity.Student;
import com.example.LibrarayDataStorage.Repository.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	StudentRepo studentrepo;

	@PostMapping("/app/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

		// System.out.println(student);

		return new ResponseEntity<>(studentrepo.save(student), HttpStatus.CREATED);
	}

	@GetMapping("/get/students")
	public ResponseEntity<List<Student>> getStudentSDetails() {
		return new ResponseEntity<>(studentrepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("get/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {

		Optional<Student> student = studentrepo.findById(id);

		if (student.isPresent()) {
			return new ResponseEntity<>(student.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	
	@PutMapping("/update/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id ,@RequestBody Student stud){
		
		Optional<Student> student=studentrepo.findById(id);
		
		if(student.isPresent()) {
			student.get().setFirstname(stud.getFirstname());
			student.get().setLastname(stud.getLastname());
			student.get().setMobilenumber(stud.getMobilenumber());
			student.get().setCollege(stud.getCollege());
			
			
		return new ResponseEntity<Student>(studentrepo.save(student.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("del/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id){
		Optional<Student> student=studentrepo.findById(id);
		 
		if(student.isPresent()) {
			studentrepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		
	}
	
	

}
