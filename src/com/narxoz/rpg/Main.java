package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Hero> party = new ArrayList<>();
        List<TowerFloor> tower = new ArrayList<>();

        for (TowerFloor floor : tower) {
            if (party.stream().noneMatch(Hero::isAlive)) break;
            FloorResult result = floor.explore(party);
            if (!result.isCleared()) break;
        }
    }
}