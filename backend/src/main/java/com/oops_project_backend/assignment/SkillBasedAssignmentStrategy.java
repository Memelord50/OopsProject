package com.oops_project_backend.assignment;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.oops_project_backend.IncidentCategory;
import com.oops_project_backend.user.Technician;

public class SkillBasedAssignmentStrategy
        implements AssignmentStrategy {

    @Override
    public Optional<Technician> assign(
            Set<IncidentCategory> requiredSkills,
            List<Technician> technicians) {

        List<Technician> eligible =
            AssignmentUtils.getEligibleTechnicians(
                requiredSkills, technicians);

        return eligible.stream()
            .max(
                Comparator
                    .comparingInt((Technician t) ->
                        AssignmentUtils.countMatchingSkills(
                            t, requiredSkills))
                    .thenComparingInt(t -> -t.getWorkload())
            );
    }
}