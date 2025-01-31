package ru.dorogov.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dorogov.web.tables.User;


public interface UserRepo extends JpaRepository<User, Long> {
}
