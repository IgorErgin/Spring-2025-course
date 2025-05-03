package Ergin.demo.listener;

import Ergin.demo.event.CustomEvent;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDateTime;

@Component
@Slf4j
public class EventListenerDemo {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void publishEvents() {
        // Публикация обычного события
        log.info("Публикация обычного события в: {}", LocalDateTime.now());
        eventPublisher.publishEvent(new CustomEvent(this, "Обычное событие"));

        // Публикация асинхронного события
        log.info("Публикация асинхронного события в: {}", LocalDateTime.now());
        eventPublisher.publishEvent(new CustomEvent(this, "Асинхронное событие"));

        // Публикация транзакционных событий
        publishTransactionalEvents();
    }

    @Transactional
    public void publishTransactionalEvents() {
        // Событие, которое будет обработано (внутри успешной транзакции)
        log.info("Публикация транзакционного события (успешного) в: {}", LocalDateTime.now());
        eventPublisher.publishEvent(new CustomEvent(this, "Транзакционное событие - успех"));

        // Событие, которое НЕ будет обработано (транзакция откатится)
        log.info("Публикация транзакционного события (откат) в: {}", LocalDateTime.now());
        eventPublisher.publishEvent(new CustomEvent(this, "Транзакционное событие - откат"));
        throw new RuntimeException("Откат транзакции");
    }

    // Обычный EventListener
    @EventListener
    public void handleRegularEvent(CustomEvent event) {
        log.info("Обработка обычного события: {} в: {}", event.getMessage(), LocalDateTime.now());
    }

    // Асинхронный EventListener
    @Async
    @EventListener
    public void handleAsyncEvent(CustomEvent event) {
        log.info("Обработка асинхронного события: {} в: {}", event.getMessage(), LocalDateTime.now());
    }

    // Транзакционный EventListener
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleTransactionalEvent(CustomEvent event) {
        log.info("Обработка транзакционного события: {} в: {}", event.getMessage(), LocalDateTime.now());
    }
}