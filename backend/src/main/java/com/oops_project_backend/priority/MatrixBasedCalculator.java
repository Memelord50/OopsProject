package com.oops_project_backend.priority;

public class MatrixBasedCalculator implements PriorityCalculator {

    @Override
    public Priority calculate(
            Impact impact,
            BusinessCriticality criticality,
            Urgency urgency) {

        Priority priority = getMatrixPriority(impact, urgency);

        return applyCriticality(priority, criticality);
    }

    private Priority getMatrixPriority(Impact impact, Urgency urgency) {

        return switch (impact) {

            case LOW -> switch (urgency) {
                case LOW -> Priority.LOW;
                case MEDIUM -> Priority.LOW;
                case HIGH -> Priority.MEDIUM;
            };

            case MEDIUM -> switch (urgency) {
                case LOW -> Priority.LOW;
                case MEDIUM -> Priority.MEDIUM;
                case HIGH -> Priority.HIGH;
            };

            case HIGH -> switch (urgency) {
                case LOW -> Priority.MEDIUM;
                case MEDIUM -> Priority.HIGH;
                case HIGH -> Priority.CRITICAL;
            };
        };
    }

    private Priority applyCriticality(
            Priority priority,
            BusinessCriticality criticality) {

        return switch (criticality) {

            case LOW -> priority;

            case MEDIUM -> switch (priority) {
                case LOW -> Priority.MEDIUM;
                default -> priority;
            };

            case HIGH -> switch (priority) {
                case LOW, MEDIUM -> Priority.HIGH;
                default -> priority;
            };
        };
    }
}
