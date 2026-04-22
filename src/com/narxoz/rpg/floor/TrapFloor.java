package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.state.PoisonedState;
import java.util.List;

public class TrapFloor extends TowerFloor {
    protected String getFloorName() { return "Poison Gas Room"; }

    protected void setup(List<Hero> party) {}

    protected FloorResult resolveChallenge(List<Hero> party) {
        int totalDmg = 0;
        for (Hero h : party) {
            if (h.isAlive()) {
                h.takeDamage(10);
                totalDmg += 10;
                h.setState(new PoisonedState());
            }
        }
        return new FloorResult(true, totalDmg, "Party survived but poisoned.");
    }

    protected void awardLoot(List<Hero> party, FloorResult result) {}
}