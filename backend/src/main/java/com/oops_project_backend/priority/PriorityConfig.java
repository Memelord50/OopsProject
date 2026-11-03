package com.oops_project_backend.priority;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriorityConfig {

    @Bean
    public PriorityCalculator priorityCalculator(
            @Value("${priority.calculator:formula}") String strategy) {

        if (strategy.equalsIgnoreCase("matrix")) {
            return new MatrixBasedCalculator();
        }

        return new FormulaBasedCalculator();
    }

    @Bean
    public PriorityService priorityService(PriorityCalculator calculator) {
        return new PriorityService(calculator);
    }
}