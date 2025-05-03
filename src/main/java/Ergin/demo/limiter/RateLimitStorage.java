package Ergin.demo.limiter;

import Ergin.demo.config.LimitConf;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class RateLimitStorage {
    private final List<Instant> requestTimes = new ArrayList<>();
    private final LimitConf config;

    public synchronized void saveReq() {
        requestTimes.add(Instant.now());
    }

    public synchronized boolean isRequestAllowed() {
        Instant cutoff = Instant.now().minusSeconds(config.getTimeWindowSeconds());

        requestTimes.removeIf(time -> time.isBefore(cutoff));

        return requestTimes.size() < config.getMaxRequests();
    }

}
