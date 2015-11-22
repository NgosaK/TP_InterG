package za.ac.tpProject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.tpProject.Domain.Topic;

/**
 * Created by User on 2015/11/22.
 */
@Repository

public interface TopicRepository extends CrudRepository<Topic, Long> {

    public Topic findById(long id);

}
