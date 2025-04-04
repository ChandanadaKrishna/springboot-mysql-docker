package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.Entity.Student;
import in.ashokit.service.StudentService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501") 
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping(value = "/add",consumes = {"application/xml","application/json"})
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		String upsert = studentService.upsert(student);
		return new ResponseEntity<String>(upsert,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/student/{id}",
			produces = {"application/json","application/xml"})
	public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
		Student student = studentService.getStudent(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@GetMapping(value = "/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> list = studentService.getAllStudents();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> upadteStudent(@RequestBody Student student){
		String upsert = studentService.upsert(student);
		return new ResponseEntity<String>(upsert, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		String deleteStudent = studentService.deleteStudent(id);
		return new ResponseEntity<String>(deleteStudent, HttpStatus.OK);
	}
	
}
