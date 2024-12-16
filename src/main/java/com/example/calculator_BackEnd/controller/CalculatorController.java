package com.example.calculator_BackEnd.controller;

import org.openapitools.model.NumberOperation;
import org.openapitools.model.OperationResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController // Indicates that this class is a Spring MVC controller where every method returns a domain object instead of a view.
@RequestMapping("/calculator") // Maps HTTP requests to handler methods of MVC and REST controllers.

public class CalculatorController {

    @PostMapping("/add") // Maps HTTP POST requests onto specific handler methods.
    public OperationResult add(@RequestBody NumberOperation operation) { // Binds the HTTP request body to a transfer or domain object.
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
