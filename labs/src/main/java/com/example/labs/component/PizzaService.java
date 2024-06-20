package com.example.labs.component;

import com.example.labs.component.maker.ChiefPizzaMaker;
import com.example.labs.component.maker.FishPizzaMaker;
import com.example.labs.component.maker.VegetarianPizzaMaker;
import com.example.labs.db.PizzaDao;
import com.example.labs.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/*
* Не используется в версии для xml только для лаб3+
* Для лаб1-2 Закоментировать аннотации Component и Autowired
 */
@Component
public class PizzaService {

    private FishPizzaMaker fishPizzaMaker;
    private VegetarianPizzaMaker vegetarianPizzaMaker;
    private PizzaDao pizzaDao;
    private ApplicationContext context;

    @Autowired
    public PizzaService(FishPizzaMaker fishPizzaMaker, VegetarianPizzaMaker vegetarianPizzaMaker, PizzaDao pizzaDao, ApplicationContext context) {
        this.fishPizzaMaker = fishPizzaMaker;
        this.vegetarianPizzaMaker = vegetarianPizzaMaker;
        this.pizzaDao = pizzaDao;
        this.context = context;
    }

    public void makePizzas() {
        fishPizzaMaker.makePizza();
        System.out.println();

        vegetarianPizzaMaker.makePizza();
        System.out.println();

        ChiefPizzaMaker chiefPizzaMaker1 = context.getBean(ChiefPizzaMaker.class);
        chiefPizzaMaker1.makePizza();
        System.out.println();

        ChiefPizzaMaker chiefPizzaMaker2 = context.getBean(ChiefPizzaMaker.class);
        chiefPizzaMaker2.makePizza();
    }

    public String createPizza(String pizzaType, String customerName) {
        return pizzaDao.createPizza(pizzaType, customerName);
    }

    public String deletePizza(String pizzaType, String customerName) {
        return pizzaDao.deletePizza(pizzaType, customerName);
    }

    public String updatePizza(String pizzaType, String customerName) {
        String newCustomerName;

        if (customerName.contains(":")) {
            String[] customerNameValues = customerName.split(":");
            customerName = customerNameValues[0];
            newCustomerName = customerNameValues[1];
        } else {
            newCustomerName = customerName;
        }

        return pizzaDao.updatePizza(pizzaType, customerName, newCustomerName);
    }

    public List<Pizza> getPizzas(String pizzaType, String customerName) {
        return pizzaDao.getPizzas(pizzaType, customerName);
    }

    public Pizza getPizza(String pizzaType, String customerName) {
        return pizzaDao.getPizza(pizzaType, customerName);
    }
}
