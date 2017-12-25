package com.yandex.mail.autotest.webpages.client;


import com.yandex.mail.autotest.webelements.Element;
import com.yandex.mail.autotest.webelements.annotations.Locator;
import com.yandex.mail.autotest.webpages.BaseWebPage;
import com.yandex.mail.autotest.webpages.annotations.WebPage;

@WebPage(path = "/")
public class StartPage extends BaseWebPage<StartPage> {

    @Locator(css = "a.new-hr-auth-Form_Button-enter")
    private Element logInButton;

    public LoginPage clickLogInButton() {
        logInButton.click();
        return loginPage;
    }
}
