package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;

public class HealthyState implements HeroState {
    public String getName() {
        return "Healthy";
    }
    public int modifyOutgoingDamage(int basePower) {
        return basePower;
    }
    public int modifyIncomingDamage(int rawDamage) {
        return rawDamage;
    }
    public void onTurnStart(Hero hero) {}
    public void onTurnEnd(Hero hero) {}
    public boolean canAct() {
        return true;
    }
}