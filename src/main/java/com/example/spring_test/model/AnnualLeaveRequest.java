package com.example.spring_test.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "annual_leave_requests")
@Data
@Entity
@RequiredArgsConstructor
public class AnnualLeaveRequest {
    private enum State{
        WAITING,
        ACCEPTED,
        DENIED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    private State state = State.WAITING;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private int day;

    @Column(name = "request_date")
    private LocalDate requestDate;




}