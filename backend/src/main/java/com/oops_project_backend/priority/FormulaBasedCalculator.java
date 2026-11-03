package com.oops_project_backend.priority;

public class FormulaBasedCalculator implements PriorityCalculator {

    @Override 
    public Priority calculate(
        Impact impact,
        BusinessCriticality criticality,
        Urgency urgency) {

        int impactScore = impactValue(impact);
        int urgencyScore = urgencyValue(urgency);
        int criticalityScore = criticalityValue(criticality);

        int score = impactScore * urgencyScore * criticalityScore;

        if (score <= 7) {
            return Priority.LOW;
        } else if (score <= 14) {
            return Priority.MEDIUM;
        } else if (score <= 21) {
            return Priority.HIGH;
        } else {
            return Priority.CRITICAL;
        }
    }

    private int impactValue(Impact impact) {
        return switch (impact) {
            case LOW -> 1;
            case MEDIUM -> 2;
            case HIGH -> 3;
        };
    }

    private int urgencyValue(Urgency urgency) {
        return switch (urgency) {
            case LOW -> 1;
            case MEDIUM -> 2;
            case HIGH -> 3;
        };
    }

    private int criticalityValue(BusinessCriticality criticality) {
        return switch (criticality) {
            case LOW -> 1;
            case MEDIUM -> 2;
            case HIGH -> 3;
        };
    }
}
