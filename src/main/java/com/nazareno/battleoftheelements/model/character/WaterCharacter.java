package com.nazareno.battleoftheelements.model.character;

import com.nazareno.battleoftheelements.model.ground.Ground;

public class WaterCharacter extends Character {

    private int vecesAlimentado = 0;
    public static final int RECUPERO_DE_ENERGIA = 10;

    public WaterCharacter() {

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
        this.vecesAlimentado++;
        if (this.vecesAlimentado > 3)
            throw new CharacterFedMoreThan3TimesException();
        this.energy.incrementarValorDadoRecuperoDeEnergia(RECUPERO_DE_ENERGIA);
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
        int valor = this.shield.coverDamage(fireCharacter.getDamageAgainstWater());
        this.life.decrementarValor(valor);
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

    @Override
    public String getType() {
        return "AGUA";
    }

    @Override
    public void passThrough(Ground ground) {
        this.energy.decrementarValor(ground.getEnergyCostDueToAWaterCharacterPassing());
    }
}
