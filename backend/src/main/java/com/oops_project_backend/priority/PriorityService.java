package com.oops_project_backend.priority;

public class PriorityService {
    
    private final PriorityCalculator calculator;

    public PriorityService(PriorityCalculator calculator) {
        this.calculator = calculator;
    }

    public Priority calculatePriority(
        Impact impact,
        BusinessCriticality criticality,
        Urgency urgency) {
            
        return calculator.calculate(impact, criticality, urgency);
    }
}
