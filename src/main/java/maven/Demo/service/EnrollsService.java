/** CREDITS : HiuHiu  -- Please don't remove this comment
 * 
 */
package maven.Demo.service;

import maven.Demo.model.EnrollDto;
import maven.Demo.repo.Enroll;
import maven.Demo.repo.EnrollsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EnrollsService {
	@Autowired EnrollsRepository repository;
	
	public void add(EnrollDto dto) {
        repository.save(toEntity(dto));
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Enroll> getEnrolls() {
        return (List<Enroll>) repository.findAll();
    }
    public Enroll getEnrollById(long id) {
        Optional<Enroll> optionalEnroll = repository.findById(id);
        return optionalEnroll.orElseThrow(() -> new EnrollNotFoundException("Couldn't find a Enroll with id: " + id));
    }
    private Enroll toEntity(EnrollDto dto) {
        Enroll entity = new Enroll();
        entity.setStudent_name(dto.getStudent_name());
        entity.setCourse_name(dto.getCourse_name());
        entity.setStudentId(dto.getStudentId());
        entity.setCourseId(dto.getCourseId());
        entity.setTime(dto.getTime());
        return entity;
    }
}
