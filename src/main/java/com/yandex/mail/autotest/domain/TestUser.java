package com.yandex.mail.autotest.domain;


import org.springframework.stereotype.Component;

@Component
public class TestUser {

    private String username;
    private String password;

    public TestUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
