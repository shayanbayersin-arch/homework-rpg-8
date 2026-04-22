package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;

public class BerserkState implements HeroState {
    public String getName() { return "Berserk"; }
    public int modifyOutgoingDamage(int basePower) {
        return basePower * 2;
    }
    public int modifyIncomingDamage(int rawDamage) {
        return (int)(rawDamage * 1.3);
    }
    public void onTurnStart(Hero hero) {}
    public void onTurnEnd(Hero hero) {
        if (hero.getHp() >= hero.getMaxHp() * 0.8) {
            hero.setState(new HealthyState());
        }
    }
    public boolean canAct() { return true; }
}