package ru.analyticalsense.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.analyticalsense.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
