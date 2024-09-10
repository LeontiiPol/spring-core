package ru.polovinko.springcore.events;

import org.springframework.context.ApplicationEvent;

public class TooMuchEmployeesEvent extends ApplicationEvent {
    public TooMuchEmployeesEvent(Object source) {
        super(source);
    }
}
