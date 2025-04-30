package study.spring_security.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import study.spring_security.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
