package com.example.calculator_BackEnd.controller;

import org.openapitools.model.NumberOperation;
import org.openapitools.model.OperationResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
@CrossOrigin(origins = "http://localhost:4200") // Allow cross-origin requests from http://localhost:4200
public class CalculatorController {

    @PostMapping("/add")
    public OperationResult add(@RequestBody NumberOperation operation) {
        BigDecimal result = operation.getNumber1().add(operation.getNumber2());
        return new OperationResult().result(result);
    }

    @PostMapping("/subtract")
    public OperationResult subtract(@RequestBody NumberOperation operation) {
        BigDecimal result = operation.getNumber1().subtract(operation.getNumber2());
        return new OperationResult().result(result);
    }

    @PostMapping("/multiply")
    public OperationResult multiply(@RequestBody NumberOperation operation) {
        BigDecimal result = operation.getNumber1().multiply(operation.getNumber2());
        return new OperationResult().result(result);
    }

    @PostMapping("/divide")
    public OperationResult divide(@RequestBody NumberOperation operation) {
        if (operation.getNumber2().compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        BigDecimal result = operation.getNumber1().divide(operation.getNumber2());
        return new OperationResult().result(result);
    }
}
