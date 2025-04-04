package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Student;
import in.ashokit.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repository;
	 
	@Override
	public String upsert(Student student) {
		repository.save(student);
		return "student saved sucessfully";
	}

	@Override
	public Student getStudent(Integer id) {
		Student student = repository.findById(id).orElse(null);
		if(student != null) {
			return student;
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = repository.findAll();
		return list;
	}

	@Override
	public String deleteStudent(Integer id) {
		boolean existsById = repository.existsById(id);
		if(existsById) {
			repository.deleteById(id);
			return "student deleted sucessfully";
		}else {
			return "record not found";
		}
	}

}
