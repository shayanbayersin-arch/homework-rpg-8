package com.narxoz.rpg.combatant;

import com.narxoz.rpg.state.HeroState;
import com.narxoz.rpg.state.HealthyState;

public class Hero {
    private final String name;
    private int hp;
    private final int maxHp;
    private final int attackPower;
    private final int defense;
    private HeroState state;

    public Hero(String name, int hp, int attackPower, int defense) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attackPower = attackPower;
        this.defense = defense;
        this.state = new HealthyState();
    }

    public String getName(){
        return name;
    }
    public int getHp(){
        return hp;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public int getAttackPower(){
        return attackPower;
    }
    public int getDefense(){
        return defense;
    }
    public boolean isAlive(){
        return hp > 0;
    }
    public HeroState getState(){
        return state;
    }

    public void setState(HeroState state) {
        this.state = state;
        System.out.println("  [STATE] " + name + " is now " + state.getName() + "!");
    }

    public void takeDamage(int amount) {
        int finalDamage = state.modifyIncomingDamage(amount);
        hp = Math.max(0, hp - finalDamage);
        System.out.println("  " + name + " takes " + finalDamage + " damage. (HP: " + hp + ")");

        if (hp > 0 && hp <= maxHp * 0.3 && state.getName().equals("Healthy")) {
            System.out.println("  [EVENT] " + name + " is at low health!");
            setState(new com.narxoz.rpg.state.BerserkState());
        }
    }

    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
        System.out.println("  " + name + " heals " + amount + " HP. (HP: " + hp + ")");
    }
}