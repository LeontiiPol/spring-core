package ru.polovinko.springcore.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.polovinko.springcore.bpp.PrototypeCleaner;

@Component
public class TooMuchEmployeesListener {

    private final PrototypeCleaner cleaner;

    public TooMuchEmployeesListener (@Autowired(required = false) PrototypeCleaner cleaner) {
        this.cleaner = cleaner;
    }

    @EventListener
    public void handleTooMuchEmployees(TooMuchEmployeesEvent event) {
        cleaner.destroy();
    }
}
