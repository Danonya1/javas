package com.example.labs.controller;

import com.example.labs.component.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
 * Не используется в версии для xml только для лаб3+
 * Для лаб1-2 Закоментировать весь класс
 */
@Controller
@RequestMapping("/")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public String orderPage() {
        return "index.html";
    }

    @PostMapping
    @ResponseBody
    public Object doPizzaAction(@RequestParam("pizzaAction") String pizzaAction,
                                @RequestParam("pizzaType") String pizzaType,
                                @RequestParam("customerName") String customerName) {

        switch (pizzaAction) {
            case "create" : {
                return pizzaService.createPizza(pizzaType, customerName);
            }
            case "update" : {
                return pizzaService.updatePizza(pizzaType, customerName);
            }
            case "get" : {
                return pizzaService.getPizza(pizzaType, customerName);
            }
            case "getAll" : {
                return pizzaService.getPizzas(pizzaType, customerName);
            }
            case "delete" : {
                return pizzaService.deletePizza(pizzaType, customerName);
            }

            default: return "Not found operation";
        }
    }
}
