package za.ac.tpProject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.tpProject.Domain.Users;

/**
 * Created by User on 2015/11/22.
 */
@Repository

public interface UsersRepository extends CrudRepository<Users, Long> {

    public Users findById(long id);

}
