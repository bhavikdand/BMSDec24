package org.example.bmsdec24.repos;

import org.example.bmsdec24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User save(User user);

    User findByEmail(String email);

}
