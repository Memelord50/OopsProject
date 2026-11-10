package com.oops_project_backend.classification;

import com.oops_project_backend.priority.Urgency;

public class UrgencyClassifier {

    public Urgency classify(ClassificationInput input) {

        if (input.workDisruption() == WorkDisruption.CRITICAL_WORK_BLOCKED
                && !input.workaroundAvailable()) {
            return Urgency.HIGH;
        }

        if (input.workDisruption() == WorkDisruption.SIGNIFICANT) {
            return Urgency.MEDIUM;
        }

        return Urgency.LOW;
    }
}