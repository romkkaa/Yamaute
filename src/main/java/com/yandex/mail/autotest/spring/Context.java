package com.yandex.mail.autotest.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;

@Component
public class Context implements ApplicationContextAware {

    private static ApplicationContext context;

    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext get() {
        return context;
    }

    @PostConstruct
    public void postConstruct() {

    }
}
