package com.agpulse.demoironbankstarter.aop;

import com.agpulse.demoironbankstarter.RavenProps;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Evgeny Borisov
 */

@Aspect
public class ExceptionHandlerAspect {

    @Autowired
    private RavenProps ravenProps;


    @Pointcut("execution(* com.agpulse.demospringbootagpulse.iron_bank..*.*(..))")
    public void allBankMethods(){}


//    {
//        Cache<String, NotEnoughMoneyException> cache = CacheBuilder.newBuilder().maximumSize(10)
//                .expireAfterWrite(1, TimeUnit.MINUTES)
//                .concurrencyLevel(1)
//                .build();
//    }

    private Map<NotEnoughMoneyException,Void> set = new WeakHashMap<>();



    @AfterThrowing(pointcut = "allBankMethods()",throwing = "ex")
    public void handleNotEnoughMoneyException(NotEnoughMoneyException ex) {
        if (!set.containsKey(ex)) {
            set.put(ex,null);
            System.out.println("raven was sent to "+ravenProps.getDestination()+" "+ex.getMessage());
        }
    }
}








