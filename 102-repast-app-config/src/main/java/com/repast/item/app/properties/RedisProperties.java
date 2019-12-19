package com.repast.item.app.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ：one group
 * @date ：Created in 2019/12/18 20:32
 * @description ：
 */
@Component
@PropertySource("classpath:config/redis.properties")
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisProperties {

    private String nodes;
    private String maxAttempts;
    private String commandTimeout;

}
