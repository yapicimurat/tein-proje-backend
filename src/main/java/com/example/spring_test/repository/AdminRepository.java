package com.example.spring_test.repository;


import com.example.spring_test.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {


    Admin findAdminByUsernameAndPassword(String username, String password);


}
