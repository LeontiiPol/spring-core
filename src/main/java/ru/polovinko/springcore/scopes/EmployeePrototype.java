package ru.polovinko.springcore.scopes;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Data
@Log4j2
public class EmployeePrototype implements Destroyable {

    private String name;
    private LocalDateTime creationTime;

    public EmployeePrototype(String name) {
        this.name = name;
    }

    @PostConstruct
    private void init() {
        log.info("Initializing employee {}", name);
        creationTime = LocalDateTime.now();
    }

    @PreDestroy
    public void destroy() {
        log.info("Destroy employee {}", name);
    }
}
