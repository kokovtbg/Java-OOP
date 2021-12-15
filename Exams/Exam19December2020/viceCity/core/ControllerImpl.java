package Exams.Exam19December2020.viceCity.core;

import Exams.Exam19December2020.viceCity.common.ConstantMessages;
import Exams.Exam19December2020.viceCity.core.interfaces.Controller;
import Exams.Exam19December2020.viceCity.models.guns.Gun;
import Exams.Exam19December2020.viceCity.models.guns.Pistol;
import Exams.Exam19December2020.viceCity.models.guns.Rifle;
import Exams.Exam19December2020.viceCity.models.neighbourhood.GangNeighbourhood;
import Exams.Exam19December2020.viceCity.models.players.CivilPlayer;
import Exams.Exam19December2020.viceCity.models.players.MainPlayer;
import Exams.Exam19December2020.viceCity.models.players.Player;
import Exams.Exam19December2020.viceCity.repositories.interfaces.classes.GunRepository;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private List<Player> players;
    private GunRepository gunRepository;
    private Player mainPlayer;
    private static int killedPlayersCount;
    private static boolean allIsOK;

    public ControllerImpl() {
        this.players = new ArrayList<>();
        this.gunRepository = new GunRepository();
        this.mainPlayer = new MainPlayer();
    }

    public static void addKilledPlayer() {
        killedPlayersCount++;
    }

    public static void setAllIsOK() {
        allIsOK = false;
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.players.add(player);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return ConstantMessages.GUN_TYPE_INVALID;
        }
        gunRepository.add(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (gunRepository.getModels().isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = gunRepository.getModels().stream().findFirst().orElse(null);
        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().getModels().add(gun);
            gunRepository.remove(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }
        Player player = players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (player == null) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        player.getGunRepository().getModels().add(gun);
        gunRepository.remove(gun);
        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        int initialCountPeople = players.size();
        killedPlayersCount = 0;
        allIsOK = true;
        GangNeighbourhood gangNeighbourhood = new GangNeighbourhood();
        gangNeighbourhood.action(mainPlayer, players);
        StringBuilder builder = new StringBuilder();
        if (allIsOK) {
            builder.append(ConstantMessages.FIGHT_HOT_HAPPENED);
        } else {
            builder.append(ConstantMessages.FIGHT_HAPPENED);
            builder.append(System.lineSeparator());
            builder.append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()));
            builder.append(System.lineSeparator());
            builder.append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, killedPlayersCount));
            builder.append(System.lineSeparator());
            builder.append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, initialCountPeople - killedPlayersCount));

        }
        return builder.toString();
    }
}
