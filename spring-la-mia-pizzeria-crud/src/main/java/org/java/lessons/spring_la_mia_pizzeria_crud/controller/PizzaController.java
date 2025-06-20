package org.java.lessons.spring_la_mia_pizzeria_crud.controller;

import java.util.List;

import org.java.lessons.spring_la_mia_pizzeria_crud.model.Pizza;
import org.java.lessons.spring_la_mia_pizzeria_crud.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model, @RequestParam(name = "keyword", required = false) String keyword) {

         List<Pizza> pizzas;
         
        if (keyword != null && !keyword.isEmpty()) {

            pizzas = pizzaRepository.findByNameContainingIgnoreCase(keyword);

        } else {

           pizzas = pizzaRepository.findAll(Sort.by("price"));;

        }

        model.addAttribute("pizzas", pizzas);

        return "pizzas/index";

    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("pizza", pizzaRepository.findById(id).get());
        return "pizzas/show";

    }

}
