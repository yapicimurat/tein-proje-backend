package com.example.spring_test.controller;


import com.example.spring_test.results.Result;
import com.example.spring_test.service.AnnualLeaveRequestService;
import com.example.spring_test.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/employee")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    private final AnnualLeaveRequestService annualLeaveRequestService;

    private final EmployeeService employeeService;

    @GetMapping(path = "/login/{username}/{password}")
    public ResponseEntity<Result> login(@PathVariable String username, @PathVariable String password){
        return ResponseEntity.ok().body( this.employeeService.login(username, password));
    }

    @GetMapping(path="/getEmployeeById/{id}")
    public ResponseEntity<Result> getUserById(@PathVariable Long id){
        return ResponseEntity.ok().body( this.employeeService.getUserById(id));
    }


}
