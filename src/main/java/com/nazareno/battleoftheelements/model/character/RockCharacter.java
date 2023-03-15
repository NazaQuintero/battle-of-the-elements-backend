package com.nazareno.battleoftheelements.model.character;

import com.nazareno.battleoftheelements.exception.CharacterFedMoreThan3TimesException;
import com.nazareno.battleoftheelements.model.ground.Ground;

public class RockCharacter extends Character {

    private static final int ENERGY_RECOVERY = 8;

    public RockCharacter() {

    }

    public RockCharacter(RockCharacter p) {
        super(p);
    }

    @Override
    public Character clone() {
        return new RockCharacter(this);
    }

    @Override
    public void feed() throws CharacterFedMoreThan3TimesException {
        this.energy.incrementValueGivenEnergyRecovery(ENERGY_RECOVERY);
    }

    @Override
    protected void receiveAttackFrom(Character attackingCharacter) {
        attackingCharacter.attackRock(this);
    }

    @Override
    protected void attackWater(WaterCharacter waterCharacter) {

    }

    @Override
    protected void attackFire(FireCharacter fireCharacter) {

    }

    @Override
    protected void attackAir(AirCharacter airCharacter) {

    }

    @Override
    protected void attackRock(RockCharacter rockCharacter) {

    }

    @Override
    protected void receiveDamageDueToAWaterCharacterHasAttacked(WaterCharacter waterCharacter) {

    }

    @Override
    protected int getDamageAgainstAir() {
        return 10;
    }

    @Override
    protected int getDamageAgainstFire() {
        return 0;
    }

    @Override
    protected void receiveDamageDueToAFireCharacterHasAttacked(FireCharacter fireCharacter) {

    }

    @Override
    protected int getDamageAgainstWater() {
        return 20;
    }

    @Override
    protected void receiveDamageDueToAnAirCharacterHasAttacked(AirCharacter airCharacter) {
        int value = this.shield.coverDamage(airCharacter.getDamageAgainstRock());
        this.life.decrementValue(value);
    }

    @Override
    protected int getDamageAgainstRock() {
        return 0;
    }

    @Override
    public String getType() {
        return CharacterType.ROCK.toString();
    }

    @Override
    public void passThrough(Ground ground) {
        this.energy.decrementValue(ground.getEnergyCostDueToARockCharacterPassing());
    }
}
