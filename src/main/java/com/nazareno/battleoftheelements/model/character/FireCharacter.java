package com.nazareno.battleoftheelements.model.character;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nazareno.battleoftheelements.exception.CharacterFedMoreThan3TimesException;
import com.nazareno.battleoftheelements.model.ground.Ground;
import jakarta.persistence.Entity;

@Entity
@JsonTypeName("FIRE")
public class FireCharacter extends Character {

    public static final int LIFE_RECOVERY = 15;

    public FireCharacter() {
        this.type = CharacterType.FIRE.toString();
    }

    public FireCharacter(FireCharacter p) {
        super(p);
    }

    @Override
    public Character clone() {
        return new FireCharacter(this);
    }

    @Override
    public void feed() throws CharacterFedMoreThan3TimesException {

        this.life.incrementValueGivenLifeRecovery(LIFE_RECOVERY);
    }

    @Override
    protected void receiveAttackFrom(Character attackingCharacter) {
        attackingCharacter.attackFire(this);
    }

    @Override
    protected void attackWater(WaterCharacter waterCharacter) {
        waterCharacter.receiveDamageDueToAFireCharacterHasAttacked(this);
    }

    @Override
    protected void attackFire(FireCharacter fireCharacter) {
        fireCharacter.receiveDamageDueToAFireCharacterHasAttacked(this);
    }

    @Override
    protected void attackAir(AirCharacter airCharacter) {
        airCharacter.receiveDamageDueToAFireCharacterHasAttacked(this);
    }

    @Override
    protected void attackRock(RockCharacter rockCharacter) {

    }

    @Override
    protected void receiveDamageDueToAWaterCharacterHasAttacked(WaterCharacter waterCharacter) {
        int value = this.shield.coverDamage(waterCharacter.getDamageAgainstFire());
        this.life.decrementValue(value);
    }

    @Override
    protected int getDamageAgainstAir() {
        return 30;
    }

    @Override
    protected int getDamageAgainstFire() {
        return 20;
    }

    @Override
    protected void receiveDamageDueToAFireCharacterHasAttacked(FireCharacter fireCharacter) {
        int value = this.shield.coverDamage(fireCharacter.getDamageAgainstFire());
        this.life.decrementValue(value);
    }

    @Override
    protected int getDamageAgainstWater() {
        return 10;
    }

    @Override
    protected void receiveDamageDueToAnAirCharacterHasAttacked(AirCharacter airCharacter) {
        int value = this.shield.coverDamage(airCharacter.getDamageAgainstFire());
        this.life.decrementValue(value);
    }

    @Override
    protected int getDamageAgainstRock() {
        return 0;
    }

//    @Override
//    public String getType() {
//        return CharacterType.FIRE.toString();
//    }

    @Override
    public void passThrough(Ground ground) {
        this.energy.decrementValue(ground.getEnergyCostDueToFireCharacterPassing());
    }
}
