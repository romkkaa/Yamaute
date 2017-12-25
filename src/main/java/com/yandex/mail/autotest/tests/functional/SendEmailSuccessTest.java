package com.yandex.mail.autotest.tests.functional;


import com.yandex.mail.autotest.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendEmailSuccessTest extends BaseTest {

    @Test
    public void sendEmailTest() {
        login()
                .clickComposeButton()
                .inputTo("tony.blair@hotmail.co.uk")
                .inputSubject("bloody hell mate")
                .inputBody("do something already")
                .clickSendButton();

        Assert.assertTrue(composeEmailPage.isEmailSuccessBlockPresent());
    }


}
