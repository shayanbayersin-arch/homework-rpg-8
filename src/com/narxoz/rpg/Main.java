package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.*;
import com.narxoz.rpg.state.PoisonedState;
import com.narxoz.rpg.tower.TowerRunResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hero arthur = new Hero("Arthur", 100, 20, 5);
        Hero lancelot = new Hero("Lancelot", 80, 25, 3);
        lancelot.setState(new PoisonedState());

        List<Hero> party = new ArrayList<>(Arrays.asList(arthur, lancelot));

        List<TowerFloor> tower = Arrays.asList(
                new CombatFloor(),
                new TrapFloor(),
                new RestFloor(),
                new BossFloor()
        );

        System.out.println("Ascending The Haunted Tower...\n");

        int floorsCleared = 0;
        for (TowerFloor floor : tower) {
            if (party.stream().noneMatch(Hero::isAlive)) {
                System.out.println("\nAll heroes have fallen.");
                break;
            }
            FloorResult result = floor.explore(party);
            if (result.isCleared()) {
                floorsCleared++;
            } else {
                break;
            }
        }

        long survivors = party.stream().filter(Hero::isAlive).count();
        boolean reachedTop = (floorsCleared == tower.size());
        TowerRunResult runResult = new TowerRunResult(floorsCleared, (int) survivors, reachedTop);

        System.out.println("\n=== TOWER RUN RESULT ===");
        System.out.println("Floors Cleared: " + runResult.getFloorsCleared() + "/" + tower.size());
        System.out.println("Heroes Surviving: " + runResult.getHeroesSurviving());
        System.out.println("Tower Defeated: " + (runResult.isReachedTop() ? "YES" : "NO"));
    }
}