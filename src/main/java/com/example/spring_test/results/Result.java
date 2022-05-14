package com.example.spring_test.results;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class Result<T> {

    private Boolean error;

    private T data;

    private String message;

}
