/** CREDITS : HiuHiu  -- Please don't remove this comment
 * 
 */
package maven.Demo.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Long> {
	@Transactional
	@Modifying
	@Query("Delete from Enroll a where student_id = ?1")
	void deleteStudentEnroll(long id);
}
