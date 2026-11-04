package com.oops_project_backend.priority;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FormulaBasedCalculatorTest {

    private final PriorityCalculator calculator =
            new FormulaBasedCalculator();

    @Test
    void allHighShouldReturnCritical() {
        assertEquals(
                Priority.CRITICAL,
                calculator.calculate(
                        Impact.HIGH,
                        BusinessCriticality.HIGH,
                        Urgency.HIGH
                )
        );
    }

    @Test
    void lowImpactShouldReturnLow() {
        assertEquals(
                Priority.LOW,
                calculator.calculate(
                        Impact.LOW,
                        BusinessCriticality.MEDIUM,
                        Urgency.HIGH
                )
        );
    }

    @Test
    void mediumScoreShouldReturnMedium() {
        assertEquals(
                Priority.MEDIUM,
                calculator.calculate(
                        Impact.MEDIUM,
                        BusinessCriticality.HIGH,
                        Urgency.MEDIUM
                )
        );
    }

    @Test
    void highScoreShouldReturnHigh() {
        assertEquals(
                Priority.HIGH,
                calculator.calculate(
                        Impact.HIGH,
                        BusinessCriticality.HIGH,
                        Urgency.MEDIUM
                )
        );
    }
}