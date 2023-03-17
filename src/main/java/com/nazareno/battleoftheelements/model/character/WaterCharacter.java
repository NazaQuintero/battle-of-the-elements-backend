package com.nazareno.battleoftheelements.model.character;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nazareno.battleoftheelements.exception.CharacterFedMoreThan3TimesException;
import com.nazareno.battleoftheelements.model.ground.Ground;
import jakarta.persistence.Entity;

@Entity
@JsonTypeName("WATER")
public class WaterCharacter extends Character {
    
    public static final int ENERGY_RECOVERY = 10;

    public WaterCharacter() {
        this.type = CharacterType.WATER.toString();
    }

    public WaterCharacter(WaterCharacter p) {
        super(p);
    }

    @Override
    public Character clone() {
        return new WaterCharacter(this);
    }

    @Override
    public void feed() throws CharacterFedMoreThan3TimesException {
        this.timesFed++;
        if (this.timesFed > 3)
            throw new CharacterFedMoreThan3TimesException();
        this.energy.incrementValueGivenEnergyRecovery(ENERGY_RECOVERY);
    }

    @Override
    public void attack(Character aCharacter) {
        aCharacter.receiveAttackFrom(this);
    }

    @Override
    protected void receiveAttackFrom(Character attackingCharacter) {
        attackingCharacter.attackWater(this);
    }

    @Override
    protected void attackWater(WaterCharacter waterCharacter) {

    }

    @Override
    protected void attackFire(FireCharacter fireCharacter) {
        fireCharacter.receiveDamageDueToAWaterCharacterHasAttacked(this);
    }

    @Override
    protected void attackAir(AirCharacter airCharacter) {
        airCharacter.receiveDamageDueToAWaterCharacterHasAttacked(this);
    }

    @Override
    protected void attackRock(RockCharacter rockCharacter) {

    }

    @Override
    protected void receiveDamageDueToAWaterCharacterHasAttacked(WaterCharacter waterCharacter) {

    }

    @Override
    protected int getDamageAgainstAir() {
        return 20;
    }

    @Override
    protected int getDamageAgainstFire() {
        return 30;
    }

    @Override
    protected void receiveDamageDueToAFireCharacterHasAttacked(FireCharacter fireCharacter) {
        int value = this.shield.coverDamage(fireCharacter.getDamageAgainstWater());
        this.life.decrementValue(value);
    }

    @Override
    protected int getDamageAgainstWater() {
        return 20;
    }

    @Override
    protected void receiveDamageDueToAnAirCharacterHasAttacked(AirCharacter airCharacter) {

    }

    @Override
    protected int getDamageAgainstRock() {
        return 0;
    }

//    @Override
//    public String getType() {
//        return CharacterType.WATER.toString();
//    }

    @Override
    public void passThrough(Ground ground) {
        this.energy.decrementValue(ground.getEnergyCostDueToAWaterCharacterPassing());
    }
}
