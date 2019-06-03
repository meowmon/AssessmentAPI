/** CREDITS : HiuHiu  -- Please don't remove this comment
 * 
 */
package maven.Demo.web;

import maven.Demo.model.CourseDto;
import maven.Demo.model.StudentDto;
import maven.Demo.repo.Student;
import maven.Demo.repo.StudentsRepository;
import maven.Demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/students")
@CrossOrigin(origins="*")
public class StudentsController {
	 @Autowired StudentsService service;
	 @Autowired StudentsRepository repository;
	    @GetMapping
	    public List<Student> getStudents() {
	        return service.getStudents();
	    }
	    @PostMapping
	    public void postStudents(@RequestBody StudentDto dto) {
	        service.add(dto);
	    }
	    @GetMapping("/{id}")
	    public Student getById(@PathVariable(required = true) long id) {
	        return service.getStudentById(id);
	    }
	    @PutMapping("/{id}")
	    public void putStudents(@PathVariable(required = true) long id, @RequestBody StudentDto dto) {
	    	service.setStudentById(id, dto);
	    }
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable(required = true) long id) {
	    	repository.deleteStudentEnroll(id);
	        service.delete(id);
	    }
}
