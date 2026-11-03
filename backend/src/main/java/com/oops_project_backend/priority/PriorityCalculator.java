package com.oops_project_backend.priority;

abstract public interface PriorityCalculator {
    
    Priority calculate(
        Impact impact, 
        BusinessCriticality criticality, 
        Urgency urgency
    );
}
