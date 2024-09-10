package ru.polovinko.springcore.bpp;

import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.polovinko.springcore.scopes.Destroyable;
import ru.polovinko.springcore.scopes.EmployeePrototype;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
@Profile("destroy")
public class PrototypeCleaner implements BeanPostProcessor, Destroyable {

    private final List<Destroyable> destroyables = new ArrayList<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof EmployeePrototype) {
            destroyables.add((EmployeePrototype) bean);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @PreDestroy
    @Override
    public void destroy() {
        destroyables.forEach(Destroyable::destroy);
        destroyables.clear();
    }
}
