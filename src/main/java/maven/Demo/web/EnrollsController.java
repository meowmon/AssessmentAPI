/** CREDITS : HiuHiu  -- Please don't remove this comment
 * 
 */
package maven.Demo.web;

import maven.Demo.model.EnrollDto;
import maven.Demo.repo.Enroll;
import maven.Demo.repo.EnrollsRepository;
import maven.Demo.service.EnrollsService;
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
@RequestMapping("/enrolls")
@CrossOrigin(origins="*")
public class EnrollsController {
	 @Autowired EnrollsService service;
	 
	 
	    @GetMapping
	    public List<Enroll> getEnrolls() {
	        return service.getEnrolls();
	    }
	    @PostMapping
	    public void postEnrolls(@RequestBody EnrollDto dto) {
	        service.add(dto);
	    }
	    @GetMapping("/{id}")
	    public Enroll getById(@PathVariable(required = true) long id) {
	        return service.getEnrollById(id);
	    }
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable(required = true) long id) {
	        service.delete(id);
	    }
}
