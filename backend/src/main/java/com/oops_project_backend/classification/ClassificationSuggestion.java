package com.oops_project_backend.classification;

import com.oops_project_backend.priority.BusinessCriticality;
import com.oops_project_backend.priority.Impact;
import com.oops_project_backend.priority.Urgency;

public record ClassificationSuggestion(
        Impact suggestedImpact,
        Urgency suggestedUrgency,
        BusinessCriticality suggestedCriticality
) {
}