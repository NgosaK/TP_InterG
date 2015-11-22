package za.ac.tpProject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.tpProject.Domain.Forum;

/**
 * Created by User on 2015/11/22.
 */
@Repository

public interface ForumRepository extends CrudRepository<Forum, Long> {
    public Forum findById(long id);
}
