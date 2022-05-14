package com.example.spring_test.service;


import com.example.spring_test.model.AnnualLeaveRequest;
import com.example.spring_test.model.Employee;
import com.example.spring_test.repository.AnnualLeaveRequestRepository;
import com.example.spring_test.repository.EmployeeRepository;
import com.example.spring_test.results.Result;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    //private final AnnualLeaveRequestService annualLeaveRequestService;

    /*
    * Employee servisinde olmasi gerekenler....
    * login
    * request for annual leave
    * get requests list
    * */

    public Result<Employee> login(String username, String password) {
        Employee employee = this.employeeRepository.findEmployeeByUsernameAndPassword(username, password);

        if(employee == null){
            return new Result(false, null, "Kullanıcı adı veya parola hatalı.");
        }

        return new Result(false, employee, "Giriş başarılı");
    }

    public Result<Employee> getUserById(Long id) {
        Employee employee = this.employeeRepository.findEmployeeById(id);

        if(employee == null){
            return new Result(false, null, "Personel bulunamadı.");
        }

        return new Result(false, employee, "Personel başarıyla bulundu.");
    }




}
