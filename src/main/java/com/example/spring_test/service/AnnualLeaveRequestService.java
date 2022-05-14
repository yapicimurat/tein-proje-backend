package com.example.spring_test.service;

import com.example.spring_test.model.AnnualLeaveRequest;
import com.example.spring_test.repository.AnnualLeaveRequestRepository;
import com.example.spring_test.repository.AnnualLeaveRequestRepository;
import com.example.spring_test.results.Result;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnualLeaveRequestService {
    private final AnnualLeaveRequestRepository annualLeaveRepository;
    private final AdminService adminService;
    private final EmployeeService employeeService;

    //CREATE SERVICE
    public Result create(int type, String username, String password, AnnualLeaveRequest annualLeaveRequest) {
        Boolean loginState = false;
        if(type == 0) // admin(0) or employee(1)
        {
            loginState = (this.adminService.login(username, password) != null) ? true : false;
        }
        else if(type == 1){
            loginState = (this.employeeService.login(username, password) != null) ? true : false;
        }
        if(loginState){
            return new Result<AnnualLeaveRequest>(false,  this.annualLeaveRepository.save(annualLeaveRequest), "İzin talebi başarıyla oluşturuldu.");
        }

        return new Result<AnnualLeaveRequest>(true, null, "İzin talebi oluşturulamadi.");
    }

    //DELETE SERVICE
    public void delete(Long id) {
        this.annualLeaveRepository.deleteById(id);
    }

    //UPDATE SERVICE
    public Result update(AnnualLeaveRequest annualLeaveRequest) {
        return new Result<AnnualLeaveRequest>(false, this.annualLeaveRepository.save(annualLeaveRequest), "İzin talebi başarıyla güncellendi");
    }

    //GET ALL SERVICE
    public Result getAll() {
        return new Result<List<AnnualLeaveRequest>>(false, this.annualLeaveRepository.findAll(),"");
    }

    //GET BY EMPLOYEE ID SERVICE
    public Result getAllRequestByEmployeeId(Long id) {
        return new Result<List<AnnualLeaveRequest>>(false, this.annualLeaveRepository.getAnnualLeaveRequestsByEmployeeId(id),"");
    }


    //GET BY REQUEST ID SERVICE
    public Result getAllRequestsByRequestId(Long id) {
        return new Result<AnnualLeaveRequest>(false, this.annualLeaveRepository.getAnnualLeaveRequestById(id), "");
    }


    public ResponseEntity<List<AnnualLeaveRequest>> getAllRequestsByEmployeeId(Long employeeId){
        List<AnnualLeaveRequest> annualLeaveRequests = this.annualLeaveRepository.getAnnualLeaveRequestsByEmployeeId(employeeId);

        return new ResponseEntity<List<AnnualLeaveRequest>>(annualLeaveRequests, HttpStatus.OK);
    }




}

