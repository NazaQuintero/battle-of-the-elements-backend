package com.nazareno.battleoftheelements.model.character;

import com.nazareno.battleoftheelements.model.ground.Ground;

public class FireCharacter extends Character {

    public static final int RECUPERO_DE_VIDA = 15;

    public FireCharacter(String nombre, Energy energy, Life life) {
        super(nombre, energy, life);
    }

    public FireCharacter() {

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

        this.life.incrementarValorDadoRecuperoDeVida(RECUPERO_DE_VIDA);
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
        int valor = this.shield.coverDamage(waterCharacter.getDamageAgainstFire());
        this.life.decrementarValor(valor);
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
        int valor = this.shield.coverDamage(fireCharacter.getDamageAgainstFire());
        this.life.decrementarValor(valor);
    }

    @Override
    protected int getDamageAgainstWater() {
        return 10;
    }

    @Override
    protected void receiveDamageDueToAnAirCharacterHasAttacked(AirCharacter airCharacter) {
        int valor = this.shield.coverDamage(airCharacter.getDamageAgainstFire());
        this.life.decrementarValor(valor);
    }

    @Override
    protected int getDamageAgainstRock() {
        return 0;
    }

    @Override
    public String getType() {
        return "FUEGO";
    }

    @Override
    public void passThrough(Ground ground) {
        this.energy.decrementarValor(ground.getEnergyCostDueToFireCharacterPassing());
    }
}
