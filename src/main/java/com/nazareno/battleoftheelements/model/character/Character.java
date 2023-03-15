package com.nazareno.battleoftheelements.model.character;

import com.nazareno.battleoftheelements.exception.CharacterFedMoreThan3TimesException;
import com.nazareno.battleoftheelements.model.common.Prototype;
import com.nazareno.battleoftheelements.model.shield.Shield;
import com.nazareno.battleoftheelements.model.shield.WithoutShield;
import com.nazareno.battleoftheelements.model.ground.Ground;

public abstract class Character implements Prototype {
    protected String name;
    protected Energy energy;
    protected Life life;
    protected Shield shield = new WithoutShield();

    public Character() {
    }

    public Character(Character p) {
        if (p != null) {
            this.name = String.valueOf(p.name);
            this.energy = new Energy(p.energy.getValue());
            this.life = new Life(p.life.getValue());
            this.shield = (Shield) p.shield.clone();
        }
    }


    public abstract Character clone();

    public Character(String name, Energy energy, Life life) {
        this.energy = energy;
        this.life = life;
        this.name = name;
    }

    public void feed() throws CharacterFedMoreThan3TimesException { }

    public int getEnergy() {
        return this.energy.getValue();
    }

    public int getLife() {
        return this.life.getValue();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
    }

    public void setLife(Life life) {
        this.life = life;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public void attack(Character aCharacter) {
        aCharacter.receiveAttackFrom(this);
    }

    protected abstract void attackWater(WaterCharacter waterCharacter);
    protected abstract void attackFire(FireCharacter fireCharacter);
    protected abstract void attackAir(AirCharacter airCharacter);
    protected abstract void attackRock(RockCharacter rockCharacter);

    protected abstract int getDamageAgainstWater();
    protected abstract int getDamageAgainstFire();
    protected abstract int getDamageAgainstAir();
    protected abstract int getDamageAgainstRock();

    protected abstract void receiveAttackFrom(Character attackingCharacter);
    protected abstract void receiveDamageDueToAWaterCharacterHasAttacked(WaterCharacter waterCharacter);
    protected abstract void receiveDamageDueToAFireCharacterHasAttacked(FireCharacter fireCharacter);
    protected abstract void receiveDamageDueToAnAirCharacterHasAttacked(AirCharacter airCharacter);

    public abstract String getType();

    public Character named(String name) {
        this.setName(name);
        return this;
    }

    public Character withEnergy(Energy energy) {
        this.setEnergy(energy);
        return this;
    }

    public Character withLife(Life life) {
        this.setLife(life);
        return this;
    }

    public abstract void passThrough(Ground ground);
}
