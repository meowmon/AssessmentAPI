/** CREDITS : HiuHiu  -- Please don't remove this comment
 * 
 */
package maven.Demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollsRepository extends CrudRepository<Enroll, Long> {

}
