package com.oops_project_backend.classification;

public class ClassificationService {

    private final ClassificationEngine engine;

    public ClassificationService(ClassificationEngine engine) {
        this.engine = engine;
    }

    public ClassificationSuggestion generateSuggestion(
            ClassificationInput input) {

        return engine.classify(input);
    }
}