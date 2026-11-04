package com.oops_project_backend.priority;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MatrixBasedCalculatorTest {

    private final PriorityCalculator calculator =
            new MatrixBasedCalculator();

    @Test
    void lowImpactLowUrgencyLowCriticality() {
        assertEquals(
                Priority.LOW,
                calculator.calculate(
                        Impact.LOW,
                        BusinessCriticality.LOW,
                        Urgency.LOW
                )
        );
    }

    @Test
    void highImpactHighUrgencyShouldReturnCritical() {
        assertEquals(
                Priority.CRITICAL,
                calculator.calculate(
                        Impact.HIGH,
                        BusinessCriticality.LOW,
                        Urgency.HIGH
                )
        );
    }

    @Test
    void highCriticalityShouldEscalateLowPriority() {
        assertEquals(
                Priority.HIGH,
                calculator.calculate(
                        Impact.LOW,
                        BusinessCriticality.HIGH,
                        Urgency.LOW
                )
        );
    }

    @Test
    void mediumCriticalityShouldEscalateLowToMedium() {
        assertEquals(
                Priority.MEDIUM,
                calculator.calculate(
                        Impact.LOW,
                        BusinessCriticality.MEDIUM,
                        Urgency.LOW
                )
        );
    }
}
