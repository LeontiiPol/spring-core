package ru.polovinko.springcore.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
public class LazyInitBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public static final String PRESCORING_SERVICE = "prescoringService";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition(PRESCORING_SERVICE);
        beanDefinition.setLazyInit(Boolean.TRUE);
        beanDefinition.setDestroyMethodName("localDestroy");
    }
}
