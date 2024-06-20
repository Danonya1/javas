package com.example.labs;

import com.example.labs.component.PizzaService;
import com.example.labs.component.maker.ChiefPizzaMaker;
import com.example.labs.component.maker.FishPizzaMaker;
import com.example.labs.component.maker.VegetarianPizzaMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Для лаб1-2 Закоментировать SpringBootApplication и строки 24-30
 * Для лаб3 Закоментрировать 33-49
 * Для лаб4+ Закоментрировать 28-49
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //Только стрка 25 для лаб4+
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

//        28-30 для 3 лабы

        PizzaService pizzaService = context.getBean(PizzaService.class);
        pizzaService.makePizzas();

//        33-49 для 1-2 лабы
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        FishPizzaMaker fishPizzaMaker = (FishPizzaMaker) context.getBean("fishPizzaMaker");
//        fishPizzaMaker.makePizza();
//        System.out.println();
//
//        VegetarianPizzaMaker vegetarianPizzaMaker = (VegetarianPizzaMaker) context.getBean("vegetarianPizzaMaker");
//        vegetarianPizzaMaker.makePizza();
//        System.out.println();
//
//        ChiefPizzaMaker chiefPizzaMaker1 = (ChiefPizzaMaker) context.getBean("chiefPizzaMaker");
//        chiefPizzaMaker1.makePizza();
//        System.out.println();
//
//        ChiefPizzaMaker chiefPizzaMaker2 = (ChiefPizzaMaker) context.getBean("chiefPizzaMaker");
//        chiefPizzaMaker2.makePizza();
//        System.out.println();
    }
}
