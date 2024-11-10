package com.kir.calculator_service.controller;

import com.kir.calculator_service.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @PostMapping("/handle")
    public double calculate(@RequestBody String expression){
        return calculatorService.calculate(expression);
    }
}
