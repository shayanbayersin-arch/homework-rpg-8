package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;

public class StunnedState implements HeroState {
    public String getName() {
        return "Stunned";
    }
    public int modifyOutgoingDamage(int basePower) {
        return 0;
    }
    public int modifyIncomingDamage(int rawDamage) {
        return (int)(rawDamage * 1.5);
    }
    public void onTurnStart(Hero hero) {}
    public void onTurnEnd(Hero hero) {
        hero.setState(new HealthyState());
    }
    public boolean canAct() {
        return false;
    }
}