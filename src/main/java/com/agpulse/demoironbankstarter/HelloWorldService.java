package com.agpulse.demoironbankstarter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */

public class HelloWorldService {

    @Scheduled(fixedDelay = 7000)
    public void sayHello(){
        System.out.println("Hello cruel world!!!");
    }
}
