package InterfacesAndAbstraction.exercise.MilitaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<PrivateImpl> privates = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String typeSoldier = data[0];
            int id = Integer.parseInt(data[1]);
            String firstName = data[2];
            String lastName = data[3];

            if (typeSoldier.equals("Private")) {
                double salary = Double.parseDouble(data[4]);
                PrivateImpl aPrivate = new PrivateImpl(id, firstName, lastName, salary);
                System.out.println(aPrivate);
                privates.add(aPrivate);
            } else if (typeSoldier.equals("LieutenantGeneral")) {
                double salary = Double.parseDouble(data[4]);
                LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                int countElements = 5;

                while (countElements < data.length) {
                    int idPrivate = Integer.parseInt(data[countElements]);
                    privates = privates.stream().peek(p -> {
                        if (p.getId() == idPrivate) {
                            lieutenantGeneral.addPrivate(p);
                        }
                    }).collect(Collectors.toList());
                    countElements++;
                }
                lieutenantGeneral.sortPrivates();
                System.out.println(lieutenantGeneral);
            } else if (typeSoldier.equals("Engineer")) {
                double salary = Double.parseDouble(data[4]);
                String corps = data[5];

                try {
                    EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
                    int countElements = 6;

                    while (countElements < data.length) {
                        String repairPart = data[countElements];
                        int repairTime = Integer.parseInt(data[countElements + 1]);
                        Repair repair = new Repair(repairPart, repairTime);
                        engineer.addRepair(repair);
                        countElements += 2;
                    }
                    System.out.println(engineer);
                } catch (IllegalArgumentException ignored) {

                }
            } else if (typeSoldier.equals("Commando")) {
                double salary = Double.parseDouble(data[4]);
                String corps = data[5];

                try {
                    CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps);
                    int countElements = 6;

                    while (countElements < data.length) {
                        String missionName = data[countElements];
                        String state = data[countElements + 1];
                        Mission mission = new Mission(missionName, state);
                        commando.addMission(mission);
                        countElements += 2;
                    }
                    System.out.println(commando);
                } catch (IllegalArgumentException ignored) {

                }
            } else if (typeSoldier.equals("Spy")) {
                String codeNumber = data[4];
                SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                System.out.println(spy);
            }

            input = scan.nextLine();
        }
    }
}
