package com.oops_project_backend.assignment;

import com.oops_project_backend.IncidentCategory;
import com.oops_project_backend.user.Technician;

import java.util.List;
import java.util.Set;
import java.util.Optional;

public class RoundRobinAssignmentStrategy
        implements AssignmentStrategy {

    private int nextIndex = 0;

    @Override
    public synchronized Optional<Technician> assign(
            Set<IncidentCategory> requiredSkills,
            List<Technician> technicians) {

        List<Technician> eligible =
            AssignmentUtils.getEligibleTechnicians(
                requiredSkills, technicians);

        if (eligible.isEmpty()) {
            return Optional.empty();
        }

        Technician selected =
            eligible.get(nextIndex % eligible.size());

        nextIndex = (nextIndex + 1) % eligible.size();

        return Optional.of(selected);
    }
}