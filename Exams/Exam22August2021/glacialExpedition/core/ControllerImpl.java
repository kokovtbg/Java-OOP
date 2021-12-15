package Exams.Exam22August2021.glacialExpedition.core;

import Exams.Exam22August2021.glacialExpedition.common.ConstantMessages;
import Exams.Exam22August2021.glacialExpedition.common.ExceptionMessages;
import Exams.Exam22August2021.glacialExpedition.models.explorers.AnimalExplorer;
import Exams.Exam22August2021.glacialExpedition.models.explorers.Explorer;
import Exams.Exam22August2021.glacialExpedition.models.explorers.GlacierExplorer;
import Exams.Exam22August2021.glacialExpedition.models.explorers.NaturalExplorer;
import Exams.Exam22August2021.glacialExpedition.models.mission.Mission;
import Exams.Exam22August2021.glacialExpedition.models.mission.MissionImpl;
import Exams.Exam22August2021.glacialExpedition.models.states.State;
import Exams.Exam22August2021.glacialExpedition.models.states.StateImpl;
import Exams.Exam22August2021.glacialExpedition.repositories.ExplorerRepository;
import Exams.Exam22August2021.glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private static final int DESIRED_ENERGY = 50;
    private static int statesExplored;
    private static final String NONE_EXHIBITS = "None";
    private static int explorersRetiredOnMission;
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        statesExplored = 0;
    }

    public static void addRetiredExplorer() {
        explorersRetiredOnMission++;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (int i = 0; i < exhibits.length; i++) {
            state.getExhibits().add(exhibits[i]);
        }
        stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.getCollection().stream()
                .filter(e -> e.getName().equals(explorerName))
                .findFirst().orElse(null);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorerRepository.remove(explorer);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        explorersRetiredOnMission = 0;
        List<Explorer> explorersWithDesiredEnergy = explorerRepository.getCollection().stream()
                .filter(e -> e.getEnergy() > DESIRED_ENERGY)
                .collect(Collectors.toList());
        if (explorersWithDesiredEnergy.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        State state = stateRepository.getCollection().stream()
                .filter(s -> s.getName().equals(stateName))
                .findFirst().orElse(null);
        Mission mission = new MissionImpl();
        mission.explore(state, explorersWithDesiredEnergy);
        for (Explorer explorer : explorerRepository.getCollection()) {
            for (Explorer explorerFromMission : explorersWithDesiredEnergy) {
                if (explorer.getName().equals(explorerFromMission.getName())) {
                    explorer = explorerFromMission;
                }
            }
        }
        stateRepository.remove(state);
        statesExplored++;
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, explorersRetiredOnMission);
    }

    @Override
    public String finalResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, statesExplored));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(ConstantMessages.FINAL_EXPLORER_INFO);
        stringBuilder.append(System.lineSeparator());

        for (Explorer explorer : explorerRepository.getCollection()) {
            stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName()));
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
            stringBuilder.append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().size() != 0) {
                stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
            } else {
                stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, NONE_EXHIBITS));
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
