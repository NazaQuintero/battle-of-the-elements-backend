package com.nazareno.battleoftheelements.model.character;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nazareno.battleoftheelements.exception.CharacterFedMoreThan3TimesException;
import com.nazareno.battleoftheelements.model.common.Prototype;
import com.nazareno.battleoftheelements.model.shield.Shield;
import com.nazareno.battleoftheelements.model.shield.WithoutShield;
import com.nazareno.battleoftheelements.model.ground.Ground;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="personage")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RockCharacter.class, name = "ROCK"),
        @JsonSubTypes.Type(value = WaterCharacter.class, name = "WATER"),
        @JsonSubTypes.Type(value = FireCharacter.class, name = "FIRE"),
        @JsonSubTypes.Type(value = AirCharacter.class, name = "AIR"),
})
public abstract class Character implements Prototype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NonNull protected int id;

    @Column(name = "dtype", insertable=false, updatable=false)
    @NonNull protected String type;

    @Column(name = "times_fed")
    @NonNull protected int timesFed = 0;

    @Column(name = "name")
    @NonNull protected String name;

    @Getter(AccessLevel.NONE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "energy_id")
    protected Energy energy;

    @Getter(AccessLevel.NONE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "life_id")
    protected Life life;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shield_id")
    protected Shield shield = new WithoutShield();

    public Character(Character p) {
        if (p != null) {
            this.id = p.id;
            this.type = String.valueOf(p.type);
            this.name = String.valueOf(p.name);
            this.energy = new Energy(p.energy.getValue());
            this.life = new Life(p.life.getValue());
            this.shield = (Shield) p.shield.clone();
        }
    }

    public abstract Character clone();

    public void feed() throws CharacterFedMoreThan3TimesException { }

    public int getEnergy() { return this.energy.getValue(); }

    public int getLife() { return this.life.getValue(); }

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
