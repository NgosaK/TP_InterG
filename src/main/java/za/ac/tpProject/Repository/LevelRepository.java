package za.ac.tpProject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.tpProject.Domain.Level;

/**
 * Created by User on 2015/11/22.
 */
@Repository

public interface LevelRepository extends CrudRepository<Level, Long> {
    public Level findById(long id);

}
