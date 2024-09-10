package ru.polovinko.springcore.bfpp;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PrescoringService {

    @PostConstruct
    private void init() {
        log.info("{} HEAVILY INITIALIZED", this);
    }

    public String prescore() {
        return "prescored";
    }

    private void localDestroy() {
        log.info("{} destroyed LOCALLY", this);
    }
}
