package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.Hero;
import java.util.List;

public class BossFloor extends CombatFloor {
    @Override
    protected String getFloorName() { return "Dragon's Lair"; }

    @Override
    protected void announce() {
        System.out.println("\n*** DANGER: " + getFloorName().toUpperCase() + " ***");
    }

    @Override
    protected void setup(List<Hero> party) {
        super.setup(party);
    }
}