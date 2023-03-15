package com.nazareno.battleoftheelements.model.character;

import com.nazareno.battleoftheelements.model.ground.Ground;

public class AirCharacter extends Character {

    public AirCharacter() {

    }

    public AirCharacter(AirCharacter p) {
        super(p);
    }

    @Override
    public Character clone() {
        return new AirCharacter(this);
    }

    @Override
    protected void receiveAttackFrom(Character attackingCharacter) {
        attackingCharacter.attackAir(this);
    }

    @Override
    protected void attackWater(WaterCharacter waterCharacter) { }

    @Override
    protected void attackFire(FireCharacter fireCharacter) {
        fireCharacter.receiveDamageDueToAnAirCharacterHasAttacked(this);
    }

    @Override
    protected void attackAir(AirCharacter airCharacter) { }

    @Override
    protected void attackRock(RockCharacter rockCharacter) {
        rockCharacter.receiveDamageDueToAnAirCharacterHasAttacked(this);
    }

    @Override
    protected void receiveDamageDueToAWaterCharacterHasAttacked(WaterCharacter waterCharacter) {
        int value = this.shield.coverDamage(waterCharacter.getDamageAgainstAir());
        this.life.decrementValue(value);
    }

    @Override
    protected int getDamageAgainstAir() {
        return 15;
    }

    @Override
    protected int getDamageAgainstFire() {
        return 10;
    }

    @Override
    protected void receiveDamageDueToAFireCharacterHasAttacked(FireCharacter fireCharacter) {
        int value = this.shield.coverDamage(fireCharacter.getDamageAgainstAir());
        this.life.decrementValue(value);
    }

    @Override
    protected int getDamageAgainstWater() {
        return 0;
    }

    @Override
    protected void receiveDamageDueToAnAirCharacterHasAttacked(AirCharacter airCharacter) {

    }

    @Override
    protected int getDamageAgainstRock() {
        return 20;
    }

    @Override
    public String getType() {
        return CharacterType.AIR.toString();
    }

    @Override
    public void passThrough(Ground ground) {
        this.energy.decrementValue(ground.getEnergyCostDueToAnAirCharacterPassing());
    }
}
