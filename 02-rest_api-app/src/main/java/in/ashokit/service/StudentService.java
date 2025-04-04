package in.ashokit.service;

import java.util.List;

import in.ashokit.Entity.Student;

public interface StudentService  {
	public String upsert(Student student);
	public Student getStudent(Integer id);
	public List<Student> getAllStudents();
	public String deleteStudent(Integer id);
	
}
