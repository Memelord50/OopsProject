package com.oops_project_backend.assignment;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.oops_project_backend.IncidentCategory;
import com.oops_project_backend.user.Technician;

public interface AssignmentStrategy {

    Optional<Technician> assign(
        Set<IncidentCategory> requiredSkills,
        List<Technician> technicians
    );
}