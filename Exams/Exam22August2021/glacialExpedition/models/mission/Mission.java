package Exams.Exam22August2021.glacialExpedition.models.mission;

import Exams.Exam22August2021.glacialExpedition.models.explorers.Explorer;
import Exams.Exam22August2021.glacialExpedition.models.states.State;

import java.util.Collection;

public interface Mission {
    void explore(State state, Collection<Explorer> explorers);
}
