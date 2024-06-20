package com.example.labs.component.maker;

import com.example.labs.component.DeliveryService;
import com.example.labs.component.PayService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * Для лаб1-2 Закоментировать аннотации Component и Autowired и Scope и PostConstruct
 */

@Component
@Scope("prototype")
public class ChiefPizzaMaker implements PizzaMaker {

    private DeliveryService deliveryService;
    private PayService payService;

    private Integer countChiefPizzaPerDay = 0;

    @Override
    public void makePizza() {
        countChiefPizzaPerDay++;
        System.out.println("Making a pizza based on " + countChiefPizzaPerDay + " chief's choice.");
        payService.pay();
        deliveryService.delivery();
    }

    public void setCountChiefPizzaPerDay(Integer countChiefPizzaPerDay) {
        this.countChiefPizzaPerDay = countChiefPizzaPerDay;
    }

    @Autowired
    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Autowired
    public void setPayService(PayService payService) {
        this.payService = payService;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("ChiefPizzaMaker is ready to make pizzas.");
    }
}