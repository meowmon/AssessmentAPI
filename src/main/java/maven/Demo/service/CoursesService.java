/** CREDITS : HiuHiu  -- Please don't remove this comment
 * 
 */
package maven.Demo.service;

import maven.Demo.model.CourseDto;
import maven.Demo.repo.Course;
import maven.Demo.repo.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CoursesService {
	@Autowired CoursesRepository repository;
	
	public void add(CourseDto dto) {
        repository.save(toEntity(dto));
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Course> getCourses() {
        return (List<Course>) repository.findAll();
    }
    public Course getCourseById(long id) {
        Optional<Course> optionalCourse = repository.findById(id);
        return optionalCourse.orElseThrow(() -> new CourseNotFoundException("Couldn't find a Course with id: " + id));
    }
    private Course toEntity(CourseDto dto) {
        Course entity = new Course();
        entity.setName(dto.getName());
        entity.setStart_date(dto.getStart_date());
        entity.setEnd_date(dto.getEnd_date());
        entity.setTuition(dto.getTuition());
        entity.setCredits(dto.getCredits());
        entity.setStatus(dto.getStatus());
        return entity;
    }
    public void setCourseById(long id, CourseDto dto) {
    	Optional<Course> oc = repository.findById(id);
    	if(oc.isPresent()) {
    		Course nc = oc.get();
    		nc.setCredits(dto.getCredits());
    		nc.setId(dto.getId());
    		nc.setEnd_date(dto.getEnd_date());
    		nc.setStart_date(dto.getStart_date());
    		nc.setTuition(dto.getTuition());
    		nc.setName(dto.getName());
    		nc.setStatus(dto.getStatus());
    		repository.save(nc);
    	}
    }
}
