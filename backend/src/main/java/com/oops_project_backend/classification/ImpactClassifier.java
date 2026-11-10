package com.oops_project_backend.classification;

import com.oops_project_backend.priority.Impact;

public class ImpactClassifier {

    public Impact classify(ClassificationInput input) {

        if (input.disruptionScope() == DisruptionScope.MULTIPLE_DEPARTMENTS ||
            input.disruptionScope() == DisruptionScope.ORGANIZATION_WIDE ||
            input.affectedUsers() > 50) {
            return Impact.HIGH;
        }

        if (input.disruptionScope() == DisruptionScope.DEPARTMENT ||
            input.affectedUsers() > 5) {
            return Impact.MEDIUM;
        }

        return Impact.LOW;
    }
}