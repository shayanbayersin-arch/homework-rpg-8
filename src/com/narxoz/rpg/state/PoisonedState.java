package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;

public class PoisonedState implements HeroState {
    private int duration = 3;

    public String getName() { return "Poisoned"; }
    public int modifyOutgoingDamage(int basePower) { return (int)(basePower * 0.8); }
    public int modifyIncomingDamage(int rawDamage) { return rawDamage; }

    public void onTurnStart(Hero hero) {
        hero.takeDamage(5);
    }

    public void onTurnEnd(Hero hero) {
        duration--;
        if (duration <= 0) {
            hero.setState(new HealthyState());
        }
    }
    public boolean canAct() { return true; }
}