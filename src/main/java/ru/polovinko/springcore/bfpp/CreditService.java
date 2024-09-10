package ru.polovinko.springcore.bfpp;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CreditService {

    private final PrescoringService prescoringService;

    public CreditService(@Lazy PrescoringService prescoringService) {
        this.prescoringService = prescoringService;
    }

    @Scheduled(initialDelay = 10_000)
    public void credit() {
        log.info("Starting credit process");
        log.info("Got prescore result {}", prescoringService.prescore());
    }
}
