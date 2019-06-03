/** CREDITS : HiuHiu  -- Please don't remove this comment
 * 
 */
package maven.Demo.service;

import maven.Demo.model.StudentDto;
import maven.Demo.model.StudentDto;
import maven.Demo.repo.Student;
import maven.Demo.repo.Student;
import maven.Demo.repo.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentsService {
	@Autowired StudentsRepository repository;
	
	public void add(StudentDto dto) {
        repository.save(toEntity(dto));
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Student> getStudents() {
        return (List<Student>) repository.findAll();
    }
    public Student getStudentById(long id) {
        Optional<Student> optionalStudent = repository.findById(id);
        return optionalStudent.orElseThrow(() -> new StudentNotFoundException("Couldn't find a Student with id: " + id));
    }
    private Student toEntity(StudentDto dto) {
        Student entity = new Student();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setGender(dto.getGender());
        entity.setBday(dto.getBday());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        return entity;
    }
	public void setStudentById(long id, StudentDto dto) {
		Optional<Student> student = repository.findById(id);
    	if(student.isPresent()) {
    		Student newStudent = student.get();
    		newStudent.setFirstName(dto.getFirstName());
    		newStudent.setId(dto.getId());
    		newStudent.setLastName(dto.getLastName());
    		newStudent.setBday(dto.getBday());
    		newStudent.setPhone(dto.getPhone());
    		newStudent.setEmail(dto.getEmail());
    		newStudent.setGender(dto.getGender());
    		repository.save(newStudent);
		}
	}
}
