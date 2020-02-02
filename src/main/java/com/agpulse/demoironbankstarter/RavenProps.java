package com.agpulse.demoironbankstarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Evgeny Borisov
 */
@Data
@ConfigurationProperties(prefix = "raven")
public class RavenProps {
    private String destination;
    private String name;

}
