package com.oops_project_backend.classification;

import com.oops_project_backend.priority.BusinessCriticality;

public record ClassificationInput(
        int affectedUsers,
        DisruptionScope disruptionScope,
        WorkDisruption workDisruption,
        boolean workaroundAvailable,
        BusinessCriticality serviceCriticality
) {
}