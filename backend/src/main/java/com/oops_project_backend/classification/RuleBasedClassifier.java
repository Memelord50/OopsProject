package com.oops_project_backend.classification;

public class RuleBasedClassifier implements ClassificationEngine {

    private final ImpactClassifier impactClassifier;
    private final UrgencyClassifier urgencyClassifier;

    public RuleBasedClassifier() {
        this.impactClassifier = new ImpactClassifier();
        this.urgencyClassifier = new UrgencyClassifier();
    }

    @Override
    public ClassificationSuggestion classify(ClassificationInput input) {

        return new ClassificationSuggestion(
                impactClassifier.classify(input),
                urgencyClassifier.classify(input),
                input.serviceCriticality()
        );
    }
}