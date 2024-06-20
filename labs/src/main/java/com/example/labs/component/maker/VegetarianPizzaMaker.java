package com.example.labs.component.maker;

import com.example.labs.component.DeliveryService;
import com.example.labs.component.PayService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Для лаб1-2 Закоментировать аннотации Component и Autowired и PostConstruct
 */

@Component
public class VegetarianPizzaMaker implements PizzaMaker {

    private DeliveryService deliveryService;
    private PayService payService;

    @Autowired
    public VegetarianPizzaMaker(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    public void makePizza() {
        System.out.println("Making a vegetarian pizza with tomato sauce, cheese, and vegetables.");
        payService.pay();
        deliveryService.delivery();
    }

    @Autowired
    public void setPayService(PayService payService) {
        this.payService = payService;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("VegetarianPizzaMaker is ready to make pizzas.");
    }
}
