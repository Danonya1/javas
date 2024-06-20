package com.example.labs.component;

import org.springframework.stereotype.Component;

/*
 * Для лаб1-2 Закоментировать аннотации Scope
 */

@Component
public class PayService {

    public void pay() {
        System.out.println("Paying...");
    }
}
