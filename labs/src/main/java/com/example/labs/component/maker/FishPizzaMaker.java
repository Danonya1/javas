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
public class FishPizzaMaker implements PizzaMaker {

    private DeliveryService deliveryService;
    private PayService payService;

    @Autowired
    public FishPizzaMaker(DeliveryService deliveryService, PayService payService) {
        this.deliveryService = deliveryService;
        this.payService = payService;
    }

    @Override
    public void makePizza() {
        System.out.println("Making a fish pizza");
        payService.pay();
        deliveryService.delivery();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("FishPizzaMaker is ready to make pizzas.");
    }
}