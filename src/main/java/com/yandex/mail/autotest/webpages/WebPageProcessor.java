package com.yandex.mail.autotest.webpages;


import com.yandex.mail.autotest.webelements.Element;
import com.yandex.mail.autotest.webelements.annotations.Locator;
import com.yandex.mail.autotest.webpages.annotations.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.Set;

@Configuration
public class WebPageProcessor implements BeanPostProcessor {

    @Override
    @Nonnull
    public Object postProcessAfterInitialization(@Nonnull Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(WebPage.class)) {
            Set<Field> annotatedElementFields = ReflectionUtils.getAllFields(
                    bean.getClass(),
                    field -> field.isAnnotationPresent(Locator.class) && WebElement.class.isAssignableFrom(field.getType())
            );
            annotatedElementFields.forEach(field -> {
                Locator locator = field.getAnnotation(Locator.class);
                field.setAccessible(true);
                try {
                    if (!locator.css().isEmpty()) {
                        field.set(bean, new Element(By.cssSelector(locator.css())));
                    } else if (!locator.xpath().isEmpty()) {
                        field.set(bean, new Element(By.xpath(locator.xpath())));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
        if (bean instanceof BaseWebPage) try {
            Field urlField = BaseWebPage.class.getDeclaredField("path");
            urlField.setAccessible(true);
            urlField.set(bean, bean.getClass().getAnnotation(WebPage.class).path());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }
}