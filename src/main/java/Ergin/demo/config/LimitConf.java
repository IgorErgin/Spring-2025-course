package Ergin.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "request.limiter")
@Getter
@Setter
public class LimitConf {
    private long maxRequests;
    private long timeWindowSeconds;
}
