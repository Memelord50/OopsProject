package com.oops_project_backend.classification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassificationConfig {

    @Bean
    public ClassificationEngine classificationEngine() {
        return new RuleBasedClassifier();
    }

    @Bean
    public ClassificationService classificationService(
            ClassificationEngine engine) {
        return new ClassificationService(engine);
    }
}