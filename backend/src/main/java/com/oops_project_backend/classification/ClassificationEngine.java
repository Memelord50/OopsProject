package com.oops_project_backend.classification;

public interface ClassificationEngine {

    ClassificationSuggestion classify(ClassificationInput input);

}