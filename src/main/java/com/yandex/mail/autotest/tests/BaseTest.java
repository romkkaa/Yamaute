package com.yandex.mail.autotest.tests;


import com.yandex.mail.autotest.helpers.SendEmailHelper;
import com.yandex.mail.autotest.domain.TestUser;
import com.yandex.mail.autotest.webpages.client.AbstractEmailClientPage;
import com.yandex.mail.autotest.webpages.client.ComposeEmailPage;
import com.yandex.mail.autotest.webpages.client.InboxPage;
import com.yandex.mail.autotest.webpages.client.StartPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = {com.yandex.mail.autotest.spring.Config.class})
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected InboxPage inboxPage;

    @Autowired
    protected StartPage startPage;

    @Autowired
    protected ComposeEmailPage composeEmailPage;

    @Autowired
    protected SendEmailHelper sendEmailHelper;

    @Autowired
    protected TestUser testUser;

    protected AbstractEmailClientPage login() {
        return startPage
                .goTo()
                .clickLogInButton()
                .inputUsername(testUser.getUsername())
                .inputPassword(testUser.getPassword())
                .clickSignInButton();
    }

}
