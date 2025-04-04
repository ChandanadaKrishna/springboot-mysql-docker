package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import in.ashokit.Entity.Student;

@CrossOrigin(origins = "http://127.0.0.1:5501")
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
