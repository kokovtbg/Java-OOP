package Exams.Exam19December2020.viceCity.models.neighbourhood;

import Exams.Exam19December2020.viceCity.core.ControllerImpl;
import Exams.Exam19December2020.viceCity.models.guns.Gun;
import Exams.Exam19December2020.viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GangNeighbourhood implements Neighbourhood {
    private static List<Player> killedPlayers;

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        killedPlayers = new ArrayList<>();
        for (Player civilPlayer : civilPlayers) {
            Collection<Gun> gunsMainPlayer = mainPlayer.getGunRepository().getModels();
            for (Gun gun : gunsMainPlayer) {
                while (gun.canFire() && civilPlayer.isAlive()) {
                    ControllerImpl.setAllIsOK();
                    civilPlayer.takeLifePoints(gun.fire());
                }
                if (!civilPlayer.isAlive()) {
                    ControllerImpl.addKilledPlayer();
                    killedPlayers.add(civilPlayer);
                    break;
                }
            }
        }
        while (!killedPlayers.isEmpty()) {
            civilPlayers.remove(killedPlayers.get(0));
            killedPlayers.remove(0);
        }
        for (Player civilPlayer : civilPlayers) {
            Collection<Gun> gunsCivilPLayer = civilPlayer.getGunRepository().getModels();
            for (Gun gun : gunsCivilPLayer) {
                while (gun.canFire() && mainPlayer.isAlive()) {
                    ControllerImpl.setAllIsOK();
                    mainPlayer.takeLifePoints(gun.fire());
                }
                if (!mainPlayer.isAlive()) {
                    break;
                }
            }
            if (!mainPlayer.isAlive()) {
                break;
            }
        }
    }
}
