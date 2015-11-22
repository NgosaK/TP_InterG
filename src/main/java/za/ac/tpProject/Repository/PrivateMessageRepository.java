package za.ac.tpProject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.tpProject.Domain.PrivateMessage;

/**
 * Created by User on 2015/11/22.
 */
@Repository

public interface PrivateMessageRepository extends CrudRepository<PrivateMessage, Long> {

    public PrivateMessage findById(long id);

}
