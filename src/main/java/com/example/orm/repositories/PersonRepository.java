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

    // Метод для поиска по названию города
    List<Person> findByCityName(String cityName);

    // Метод для поиска людей младше указанного возраста, отсортированных по возрастанию
    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    // Метод для поиска по имени и фамилии, возвращающий Optional
    Optional<Person> findByNameAndSurname(String name, String surname);

    // Дополнительные методы для удобства
    List<Person> findByAge(int age);
    
    List<Person> findByNameContainingIgnoreCase(String name);
    
    List<Person> findBySurnameContainingIgnoreCase(String surname);

    // Кастомный запрос для поиска по городу (альтернативный способ)
    @Query("SELECT p FROM Person p WHERE p.city.name = :cityName")
    List<Person> findPersonsByCityName(@Param("cityName") String cityName);
}
