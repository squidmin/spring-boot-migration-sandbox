package org.squidmin.java.spring.springbootmigrationsandbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.squidmin.java.spring.springbootmigrationsandbox.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
