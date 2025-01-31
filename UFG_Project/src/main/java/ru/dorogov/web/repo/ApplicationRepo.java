package ru.dorogov.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dorogov.web.tables.Application;
import ru.dorogov.web.tables.Client;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
}
