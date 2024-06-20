package com.example.labs.component;

import org.springframework.stereotype.Component;

/*
 * Для лаб1-2 Закоментировать аннотации Scope
 */

@Component
public class DeliveryService {

    public void delivery() {
        System.out.println("Delivering...");
    }
}
