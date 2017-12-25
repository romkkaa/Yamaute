package com.yandex.mail.autotest.webpages;


import com.yandex.mail.autotest.webdriver.Driver;
import com.yandex.mail.autotest.webpages.client.ComposeEmailPage;
import com.yandex.mail.autotest.webpages.client.InboxPage;
import com.yandex.mail.autotest.webpages.client.LoginPage;
import com.yandex.mail.autotest.webpages.client.StartPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseWebPage<T> {

    @Autowired
    protected InboxPage inboxPage;

    @Autowired
    protected LoginPage loginPage;

    @Autowired
    protected StartPage startPage;

    @Autowired
    protected ComposeEmailPage composeEmailPage;

    @Value("${environment}")
    private String environmentUrl;

    private String path;

    public String getPath() {
        return path;
    }

    @SuppressWarnings("unchecked")
    public T goTo() {
        Driver.getDriver().get(environmentUrl + path);
        return (T) this;
    }

}