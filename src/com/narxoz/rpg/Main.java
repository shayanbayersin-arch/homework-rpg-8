package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.*;
import com.narxoz.rpg.state.PoisonedState;
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

        int floorsCleared = 0;
        for (TowerFloor floor : tower) {
            if (party.stream().noneMatch(Hero::isAlive)) break;
            FloorResult result = floor.explore(party);
            if (result.isCleared()) floorsCleared++;
            else break;
        }
    }
}