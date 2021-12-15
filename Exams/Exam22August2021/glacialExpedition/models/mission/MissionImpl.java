package Exams.Exam22August2021.glacialExpedition.models.mission;

import Exams.Exam22August2021.glacialExpedition.core.ControllerImpl;
import Exams.Exam22August2021.glacialExpedition.models.explorers.Explorer;
import Exams.Exam22August2021.glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && !state.getExhibits().isEmpty()) {
                explorer.search();
                String exhibit = state.getExhibits().stream().findFirst().orElse(null);
                explorer.getSuitcase().getExhibits().add(exhibit);
                state.getExhibits().remove(exhibit);
            }
            if (!explorer.canSearch()) {
                ControllerImpl.addRetiredExplorer();
            }
        }
    }
}
