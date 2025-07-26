package com.example.orm.repositories;

import com.example.orm.entitys.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class hibRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery(
                                    "SELECT p FROM Person p WHERE p.city.name = :city", Person.class)
                            .setParameter("city", city)
                            .getResultList();
    }
}
