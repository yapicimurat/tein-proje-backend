package com.example.spring_test.controller;


import com.example.spring_test.model.AnnualLeaveRequest;
import com.example.spring_test.results.Result;
import com.example.spring_test.service.AnnualLeaveRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/annual_request")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnnualLeaveRequestController {

    private final AnnualLeaveRequestService annualLeaveRequestService;

    @GetMapping(path = "/")
    public ResponseEntity<Result> getAll() {
        return ResponseEntity.ok().body(this.annualLeaveRequestService.getAll());
    }

    @GetMapping(path = "/getAllByEmployeeId/{id}")
    public ResponseEntity<Result> getAllByEmployeeId(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.annualLeaveRequestService.getAllRequestByEmployeeId(id));
    }

    @GetMapping(path = "/getByRequestId/{id}")
    public ResponseEntity<Result> getAllByRequestId(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.annualLeaveRequestService.getAllRequestsByRequestId(id));
    }

    @PostMapping(path = "/create/{type}/{username}/{password}")
    //type => admin(0) or employee(1) -> kullanici adi ve parola kontrol edilip degisiklikler yapilabilir
    public ResponseEntity<Result> create(@PathVariable int type, @PathVariable String username, @PathVariable String password, @RequestBody AnnualLeaveRequest annualLeaveRequest) {

        return ResponseEntity.ok().body(this.annualLeaveRequestService.create(type, username, password, annualLeaveRequest));
    }

    @PutMapping(path = "/save/{type}/{username}/{password}")
    //type => admin(0) or employee(1) -> kullanici adi ve parola kontrol edilip degisiklikler yapilabilir
    public ResponseEntity<Result> save(@PathVariable Boolean type, @PathVariable String username, @PathVariable String password, @RequestBody AnnualLeaveRequest annualLeaveRequest) {
        return ResponseEntity.ok().body(this.annualLeaveRequestService.update(annualLeaveRequest));
    }


}
