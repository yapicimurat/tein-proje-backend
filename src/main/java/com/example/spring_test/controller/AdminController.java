package com.example.spring_test.controller;


import com.example.spring_test.results.Result;
import com.example.spring_test.service.AdminService;
import com.example.spring_test.service.AnnualLeaveRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    private final AdminService adminService;

    private final AnnualLeaveRequestService annualLeaveRequestService;

    @GetMapping(path = "/login/{username}/{password}")
    public ResponseEntity<Result> login(@PathVariable String username, @PathVariable String password)
    {
        return ResponseEntity.ok().body(this.adminService.login(username, password));
    }




}
