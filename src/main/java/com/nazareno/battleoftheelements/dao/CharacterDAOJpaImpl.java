package com.nazareno.battleoftheelements.dao;

import com.nazareno.battleoftheelements.model.character.Character;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterDAOJpaImpl implements CharacterDAO {

    private EntityManager entityManager;

    @Autowired
    public CharacterDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Character> findAll() {
        TypedQuery<Character> query = entityManager.createQuery("from Character", Character.class);
        return query.getResultList();
    }

    @Override
    public Character findById(int id) {
        return entityManager.find(Character.class, id);
    }

    @Override
    public Character save(Character character) {
        return entityManager.merge(character);
    }

    @Override
    public void deleteById(int id) {
        Character character = entityManager.find(Character.class, id);
        entityManager.remove(character);
    }
}
