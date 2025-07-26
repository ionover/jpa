package com.example.orm.repositories;

import com.example.orm.entitys.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.city.name = :cityName")
    List<Person> findByCityName(@Param("cityName") String cityName);

    @Query("SELECT p FROM Person p WHERE p.age < :age ORDER BY p.age ASC")
    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") int age);

    @Query("SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Query("SELECT p FROM Person p WHERE p.age = :age")
    List<Person> findByAge(@Param("age") int age);

    @Query("SELECT p FROM Person p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Person> findByNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT p FROM Person p WHERE LOWER(p.surname) LIKE LOWER(CONCAT('%', :surname, '%'))")
    List<Person> findBySurnameContainingIgnoreCase(@Param("surname") String surname);
}
