package com.kir.calculator_service.service;

import com.kir.calculator_service.util.CalculatorUtil;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(String expression){
        return CalculatorUtil.calculate(expression);
    }
}
