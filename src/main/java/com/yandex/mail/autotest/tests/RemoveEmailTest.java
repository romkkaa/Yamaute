package com.yandex.mail.autotest.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RemoveEmailTest extends BaseTest {

    @BeforeClass
    public void receiveEmail() {
        sendEmailHelper.sendBasicEmail();
    }

    @Test
    public void removeEmailTest(){
        login();
    }

}
