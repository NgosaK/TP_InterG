package za.ac.tpProject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.tpProject.Domain.SubForum;

/**
 * Created by User on 2015/11/22.
 */
@Repository

public interface SubForumRepository extends CrudRepository<SubForum, Long> {

    public SubForum findById(long id);

}
