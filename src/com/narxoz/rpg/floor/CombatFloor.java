package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.Monster;
import com.narxoz.rpg.state.StunnedState;
import java.util.List;

public class CombatFloor extends TowerFloor {
    private Monster monster;

    protected String getFloorName() { return "Monster Chamber"; }

    protected void setup(List<Hero> party) {
        monster = new Monster("Skeleton Warrior", 50, 15);
    }

    protected FloorResult resolveChallenge(List<Hero> party) {
        int initialTotalHp = party.stream().mapToInt(Hero::getHp).sum();

        while (monster.isAlive() && party.stream().anyMatch(Hero::isAlive)) {
            for (Hero hero : party) {
                if (!hero.isAlive() || !monster.isAlive()) continue;

                hero.getState().onTurnStart(hero);
                if (hero.isAlive() && hero.getState().canAct()) {
                    int damage = hero.getState().modifyOutgoingDamage(hero.getAttackPower());
                    monster.takeDamage(damage);
                }
                hero.getState().onTurnEnd(hero);
            }

            if (monster.isAlive()) {
                Hero target = party.stream().filter(Hero::isAlive).findFirst().orElse(null);
                if (target != null) {
                    monster.attack(target);
                    if (target.isAlive() && Math.random() > 0.7 && target.getState().getName().equals("Healthy")) {
                        target.setState(new StunnedState());
                    }
                }
            }
        }
        boolean cleared = !monster.isAlive();
        int endTotalHp = party.stream().mapToInt(Hero::getHp).sum();
        return new FloorResult(cleared, initialTotalHp - endTotalHp, cleared ? "Monster defeated!" : "Party wiped.");
    }

    protected void awardLoot(List<Hero> party, FloorResult result) {}
}