package com.yandex.mail.autotest.spring;


import com.yandex.mail.autotest.domain.TestUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.yandex.mail.autotest"})
@PropertySource("classpath:/properties/test.properties")
public class Config {

    @Bean
    public TestUser testUser() {
        return new TestUser(System.getProperty("username"), System.getProperty("password"));
    }
}
