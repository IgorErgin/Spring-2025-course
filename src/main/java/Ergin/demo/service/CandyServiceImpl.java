package Ergin.demo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandyServiceImpl implements CandyService {
    private final MeterRegistry meterRegistry;
    private Counter totalCandiesCounter;
    private Counter generalCandiesCounter;
    private Timer executionTimer;

    @PostConstruct
    public void init() {
        this.totalCandiesCounter = Counter.builder("candies.total")
                .description("Total candies by item")
                .register(meterRegistry);

        this.generalCandiesCounter = Counter.builder("candies.count")
                .description("Total candies count")
                .register(meterRegistry);

        this.executionTimer = Timer.builder("orders.execution.time")
                .description("Time to process getOrder")
                .publishPercentiles(0.5, 0.95)
                .register(meterRegistry);
    }

    @Override
    public String createOrder(String itemName) {
        return executionTimer.record(() -> {
            generalCandiesCounter.increment();
            totalCandiesCounter.increment();

            return "Order " + itemName + " successful created!";
        });
    }
}
