package ru.polovinko.springcore.scopes;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class ScopeConfig {

    @Bean(name = "employee")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public EmployeePrototype getEmployee(String name) {
        return new EmployeePrototype(name);
    }

    @Bean
    @RequestScope
    public RequestHandler getRequestHandler() {
        return new RequestHandler();
    }
}
