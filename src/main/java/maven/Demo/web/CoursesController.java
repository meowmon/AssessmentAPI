/** CREDITS : HiuHiu  -- Please don't remove this comment
 * 
 */
package maven.Demo.web;

import maven.Demo.model.CourseDto;
import maven.Demo.repo.Course;
import maven.Demo.repo.CoursesRepository;
import maven.Demo.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/courses")
@CrossOrigin(origins="*")
public class CoursesController {
	 @Autowired CoursesService service;
	 @Autowired CoursesRepository repository;
	    @GetMapping
	    public List<Course> getCourses() {
	        return service.getCourses();
	    }
	    @PostMapping
	    public void postCourses(@RequestBody CourseDto dto) {
	        service.add(dto);
	    }
	    @PutMapping("/{id}")
	    public void putCourses(@PathVariable(required = true) long id, @RequestBody CourseDto dto) {
	    	service.setCourseById(id, dto);
	    }
	    @GetMapping("/status/{status}")
	    public List<Course> getCourseByStatus(@PathVariable(required = true) String status){
			return repository.getCourseByStatus(status);
	    }
	    
	    @GetMapping("/{id}")
	    public Course getById(@PathVariable(required = true) long id) {
	        return service.getCourseById(id);
	    }
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable(required = true) long id) {
	        service.delete(id);
	    }
}
