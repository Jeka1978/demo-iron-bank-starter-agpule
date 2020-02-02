package com.agpulse.demoironbankstarter.aop;

/**
 * @author Evgeny Borisov
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message);

    }
}
