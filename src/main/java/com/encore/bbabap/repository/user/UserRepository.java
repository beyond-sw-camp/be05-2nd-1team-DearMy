package com.encore.bbabap.repository.user;

import com.encore.bbabap.domain.user.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findUsersByDeletedYnFalse();
}
