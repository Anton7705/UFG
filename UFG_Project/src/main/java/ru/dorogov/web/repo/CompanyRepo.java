package ru.dorogov.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.dorogov.web.tables.Company;

import java.util.List;


public interface CompanyRepo extends JpaRepository<Company, Long> {

//    @Query(value = "select * from Employee where depId = ?1", nativeQuery = true)
//    List<Company> asd();
}
