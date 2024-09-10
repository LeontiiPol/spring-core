package ru.polovinko.springcore.scopes;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Log4j2
public class RequestHandler implements Destroyable {

    @PostConstruct
    private void init() {
        log.info("Initializing REQUEST SCOPE bean {}", this);
    }

    @PreDestroy
    public void destroy() {
        log.info("Destroying REQUEST SCOPE bean {}", this);
    }

    public String sayHello() {
        return "Hello from " + this + " at:" + DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss").format(LocalDateTime.now());
    }
}
