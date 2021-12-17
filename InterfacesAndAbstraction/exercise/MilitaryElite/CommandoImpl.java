package InterfacesAndAbstraction.exercise.MilitaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void completeMission(String mission) {
        missions = missions.stream().peek(m -> {
            if (m.getCodeName().equals(mission)) {
                m.setState(Mission.MissionState.FINISHED.getValue());
            }
        }).collect(Collectors.toSet());
    }

    public void addMission(Mission mission) {
        if (mission.getState().equals(Mission.MissionState.FINISHED.getValue()) || mission.getState().equals(Mission.MissionState.IN_PROGRESS.getValue())) {
            this.missions.add(mission);
        }
    }

    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(this.getFirstName()).append(" ").append(this.getLastName()).append(" Id: ").append(this.getId()).append(" Salary: ").append(String.format("%.2f", this.getSalary())).append(System.lineSeparator());
        builder.append("Corps: ").append(this.getCorps()).append(System.lineSeparator());
        builder.append("Missions:").append(System.lineSeparator());
        missions.forEach(m -> builder.append("  ").append(m).append(System.lineSeparator()));

        return builder.toString().trim();
    }
}
