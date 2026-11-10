package com.oops_project_backend.assignment;

import com.oops_project_backend.IncidentCategory;
import com.oops_project_backend.user.Technician;
import com.oops_project_backend.user.Availability;

import java.util.List;
import java.util.Set;

final class AssignmentUtils {

    private AssignmentUtils() {}

    static List<Technician> getEligibleTechnicians(
        Set<IncidentCategory> requiredSkills,
        List<Technician> technicians
    ) {
        if (requiredSkills == null || requiredSkills.isEmpty()
                || technicians == null) {
            return List.of();
        }

        return technicians.stream()
            .filter(t -> t.getAvailability() == Availability.AVAILABLE)
            .filter(t -> t.getSkills().stream()
                .anyMatch(requiredSkills::contains))
            .toList();
    }

    static int countMatchingSkills(
        Technician technician,
        Set<IncidentCategory> requiredSkills
    ) {
        return (int) technician.getSkills().stream()
            .filter(requiredSkills::contains)
            .count();
    }
}