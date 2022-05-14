package com.example.spring_test.repository;

import com.example.spring_test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByUsernameAndPassword(String username, String password);


    Employee findEmployeeById(Long id);


}
