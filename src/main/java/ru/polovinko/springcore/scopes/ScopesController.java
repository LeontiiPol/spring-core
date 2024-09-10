package ru.polovinko.springcore.scopes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.polovinko.springcore.events.TooMuchEmployeesEvent;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/scopes")
public class ScopesController {

    private final ScopeConfig scopeConfig;
    private final RequestHandler requestHandler;
    private final String profileVariable;
    private final AtomicLong employeesCounter;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ScopesController(ScopeConfig scopeConfig,
                            RequestHandler requestHandler,
                            ApplicationEventPublisher applicationEventPublisher,
                            @Value("${profile.var}") String profileVariable
    ) {
        this.scopeConfig = scopeConfig;
        this.requestHandler = requestHandler;
        this.profileVariable = profileVariable;
        this.applicationEventPublisher = applicationEventPublisher;
        employeesCounter = new AtomicLong();
    }

    @GetMapping("/prototype")
    public EmployeePrototype prototype(@RequestParam String name) {
        if (employeesCounter.incrementAndGet() > 3) {
            applicationEventPublisher.publishEvent(new TooMuchEmployeesEvent(this));
            employeesCounter.set(1);
        }
        return scopeConfig.getEmployee(name);
    }

    @GetMapping("/request")
    public String request() {
        return requestHandler.sayHello();
    }

    @GetMapping("/profile")
    public String profile() {
        return profileVariable;
    }
}
