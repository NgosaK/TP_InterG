package za.ac.tpProject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.tpProject.Domain.Post;

/**
 * Created by User on 2015/11/22.
 */
@Repository

public interface PostRepository extends CrudRepository<Post, Long> {

    public Post findById(long id);

}
