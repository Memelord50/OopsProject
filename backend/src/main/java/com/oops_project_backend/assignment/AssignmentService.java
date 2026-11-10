package com.oops_project_backend.assignment;

import com.oops_project_backend.IncidentCategory;
import com.oops_project_backend.user.Technician;

import java.util.List;
import java.util.Set;
import java.util.Optional;

public class AssignmentService {

    private final AssignmentStrategy strategy;

    public AssignmentService(AssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public Optional<Technician> assignTechnician(
            Set<IncidentCategory> requiredSkills,
            List<Technician> technicians) {

        return strategy.assign(requiredSkills, technicians);
    }
}