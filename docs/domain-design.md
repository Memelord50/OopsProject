# Backend — Domain Design Notes

## 1. Incident lifecycle

The initial incident lifecycle is:

`REPORTED → CLASSIFIED → ASSIGNED → INVESTIGATING → RESOLVED → VERIFIED → CLOSED`

Additional transitions:
- Failed verification: `RESOLVED → INVESTIGATING`
- Reopening a closed incident: `CLOSED → INVESTIGATING`, with a reason recorded.

## 2. Classification enums

- **Impact:** LOW, MEDIUM, HIGH
- **Urgency:** LOW, MEDIUM, HIGH
- **Priority:** LOW, MEDIUM, HIGH, CRITICAL

Priority will be determined using impact, urgency, and business criticality. The exact calculation remains to be designed.

## 3. Object-oriented design

- `Incident` will encapsulate domain rules and valid state transitions.
- An `IncidentService` will coordinate operations, persistence, and workflow-related actions.
- Fixed classification values and lifecycle states will use Java enums.

## 4. Automated reassignment

If a technician's proposed resolution fails verification three times on the same incident, the system will trigger reassignment to another eligible technician when possible.

Failed verification attempts and reassignment decisions must be recorded in the incident history.

## 5. Pending design decisions

- Define the priority calculation matrix.
- Define business-criticality levels.
- Finalize technician assignment strategies.
- Define SLA behaviour for reopened incidents.
- Define permissions for lifecycle transitions.
