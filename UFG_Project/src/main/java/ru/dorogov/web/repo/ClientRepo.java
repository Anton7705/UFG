package ru.dorogov.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dorogov.web.tables.Client;


public interface ClientRepo extends JpaRepository<Client, Long> {
}
