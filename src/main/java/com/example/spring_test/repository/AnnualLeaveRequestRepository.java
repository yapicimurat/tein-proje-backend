package com.example.spring_test.repository;


import com.example.spring_test.model.AnnualLeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnualLeaveRequestRepository extends JpaRepository<AnnualLeaveRequest, Long> {


    List<AnnualLeaveRequest> findAll();

    AnnualLeaveRequest getAnnualLeaveRequestById(Long id);

    List<AnnualLeaveRequest> getAnnualLeaveRequestsByEmployeeId(Long employeeId);


    void deleteById(Long id);

}
