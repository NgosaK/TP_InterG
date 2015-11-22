package za.ac.tpProject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.tpProject.Domain.Extra;

/**
 * Created by User on 2015/11/22.
 */
@Repository

public interface ExtraRepository extends CrudRepository<Extra, Long> {

    public Extra findById(long id);
}
