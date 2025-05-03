package Ergin.demo.limiter;

import Ergin.demo.exception.RateLimitException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class RateLimitAspect {

    private final RateLimitStorage store;

    @Before("@annotation(RateLimit)")
    public void beforeRateLimit() {
        if (!store.isRequestAllowed()) {
            throw new RateLimitException("TOO MANY REQUESTS");
        }

        store.saveReq();
    }
}
