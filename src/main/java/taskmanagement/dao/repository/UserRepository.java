package taskmanagement.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskmanagement.dao.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {



    /////// USER eyni deyil
    boolean existsByEmailAndIsActiveTrue(String email);
//    Optional<User> findByEmailAndIsDeletedFalse(String email);
    Optional<User> findByUsernameAndIsActiveTrue(String username);

    Optional<User> findByEmailAndIsActiveTrue(String email);

}
