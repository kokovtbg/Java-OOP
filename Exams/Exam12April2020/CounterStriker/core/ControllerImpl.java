package Exams.Exam12April2020.CounterStriker.core;

import Exams.Exam12April2020.CounterStriker.common.ExceptionMessages;
import Exams.Exam12April2020.CounterStriker.common.OutputMessages;
import Exams.Exam12April2020.CounterStriker.models.field.Field;
import Exams.Exam12April2020.CounterStriker.models.field.FieldImpl;
import Exams.Exam12April2020.CounterStriker.models.guns.Gun;
import Exams.Exam12April2020.CounterStriker.models.guns.Pistol;
import Exams.Exam12April2020.CounterStriker.models.guns.Rifle;
import Exams.Exam12April2020.CounterStriker.models.players.CounterTerrorist;
import Exams.Exam12April2020.CounterStriker.models.players.Player;
import Exams.Exam12April2020.CounterStriker.models.players.Terrorist;
import Exams.Exam12April2020.CounterStriker.repositories.GunRepository;
import Exams.Exam12April2020.CounterStriker.repositories.PlayerRepository;

public class ControllerImpl implements Controller {
    private GunRepository gunRepository;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.gunRepository = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
        }
        this.gunRepository.add(gun);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = gunRepository.findByName(gunName);
        if (gun == null) {
            throw new NullPointerException(ExceptionMessages.GUN_CANNOT_BE_FOUND);
        }
        Player player;
        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        this.players.add(player);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return field.start(players.getModels());
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        players.getModels().stream().sorted((p1, p2) -> {
            int result = p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
            if (result == 0) {
                result = Integer.compare(p2.getHealth(), p1.getHealth());
                if (result == 0) {
                    result = p1.getUsername().compareTo(p2.getUsername());
                }
            }
            return result;
        }).forEach(p -> {
            builder.append(String.format("%s: %s", p.getClass().getSimpleName(), p.getUsername()));
            builder.append(System.lineSeparator());
            builder.append(String.format("--Health: %d", p.getHealth()));
            builder.append(System.lineSeparator());
            builder.append(String.format("--Armor: %d", p.getArmor()));
            builder.append(System.lineSeparator());
            builder.append(String.format("--Gun: %s", p.getGun().getName()));
            builder.append(System.lineSeparator());
        });
        return builder.toString().trim();
    }
}
