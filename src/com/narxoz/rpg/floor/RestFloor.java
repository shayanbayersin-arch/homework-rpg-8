package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.state.HealthyState;
import java.util.List;

public class RestFloor extends TowerFloor {
    protected String getFloorName() { return "Sanctuary Fountain"; }

    protected void setup(List<Hero> party) {}

    protected FloorResult resolveChallenge(List<Hero> party) {
        for (Hero h : party) {
            if (h.isAlive()) {
                h.heal(20);
                if (!h.getState().getName().equals("Healthy")) {
                    h.setState(new HealthyState());
                }
            }
        }
        return new FloorResult(true, 0, "Party rested.");
    }

    @Override
    protected boolean shouldAwardLoot(FloorResult result) {
        return false;
    }

    protected void awardLoot(List<Hero> party, FloorResult result) {}
}