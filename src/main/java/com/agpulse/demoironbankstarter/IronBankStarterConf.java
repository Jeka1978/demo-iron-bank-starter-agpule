package com.agpulse.demoironbankstarter;

import com.agpulse.demoironbankstarter.aop.ExceptionHandlerAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Evgeny Borisov
 */
@Configuration
@EnableScheduling
@EnableConfigurationProperties(RavenProps.class)
public class IronBankStarterConf {


    @Bean
    public FrontendControllerAdvice frontendControllerAdvice(){
        return new FrontendControllerAdvice();
    }

    @Bean
    @ConditionalOnProd
    @ConditionalOnProperty(name = "raven.destination")
    public ExceptionHandlerAspect exceptionHandlerAspect(){
        return new ExceptionHandlerAspect();
    }

    @Bean
    public HelloWorldService helloWorldService(){
        return new HelloWorldService();
    }
}



