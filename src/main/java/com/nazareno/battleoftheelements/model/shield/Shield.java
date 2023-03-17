package com.nazareno.battleoftheelements.model.shield;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nazareno.battleoftheelements.model.character.AirCharacter;
import com.nazareno.battleoftheelements.model.character.FireCharacter;
import com.nazareno.battleoftheelements.model.character.RockCharacter;
import com.nazareno.battleoftheelements.model.character.WaterCharacter;
import com.nazareno.battleoftheelements.model.common.Prototype;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shield")
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
        @JsonSubTypes.Type(value = WithoutShield.class, name = "NONE"),
        @JsonSubTypes.Type(value = OneShield.class, name = "ONE"),
        @JsonSubTypes.Type(value = TwoShields.class, name = "TWO"),
        @JsonSubTypes.Type(value = MoreThanTwoShields.class, name = "TWOPLUS"),
})
public abstract class Shield implements Prototype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dtype", insertable=false, updatable=false)
    @NonNull protected String type;

    public abstract int coverDamage(int damage);
    public abstract Prototype clone();
}
