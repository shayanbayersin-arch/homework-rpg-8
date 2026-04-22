package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.Hero;
import java.util.List;

public class CombatFloor extends TowerFloor {
    protected String getFloorName() { return "Monster Chamber"; }

    protected void setup(List<Hero> party) {}

    protected FloorResult resolveChallenge(List<Hero> party) {
        return new FloorResult(true, 0, "Fast combat resolved.");
    }

    protected void awardLoot(List<Hero> party, FloorResult result) {}
}