package com.yandex.mail.autotest.tests.functional;


import com.yandex.mail.autotest.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RemoveEmailTest extends BaseTest {

    private String emailSubject;

    @BeforeClass
    public void receiveEmail() {
        emailSubject = sendEmailHelper.sendBasicEmail();
    }

    @Test
    public void removeEmailTest(){
        login()
                .clickInboxLink()
                .selectEmailBySubject(emailSubject)
                .clickDeleteButton();
    }

}
