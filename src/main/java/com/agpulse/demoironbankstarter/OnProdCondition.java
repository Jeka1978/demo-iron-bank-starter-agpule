package com.agpulse.demoironbankstarter;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.swing.*;

/**
 * @author Evgeny Borisov
 */
public class OnProdCondition implements Condition {
    private static String answer;
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (answer==null) {
            answer = JOptionPane.showInputDialog("is it production?");
        }
        return answer.toLowerCase().contains("yes");
    }
}
