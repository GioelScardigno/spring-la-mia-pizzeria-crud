package org.java.lessons.spring_la_mia_pizzeria_crud.repo;

import java.util.List;

import org.java.lessons.spring_la_mia_pizzeria_crud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    
    public List<Pizza> findByName(String name);

    public List<Pizza> findByNameContainingIgnoreCase(String name);

}
