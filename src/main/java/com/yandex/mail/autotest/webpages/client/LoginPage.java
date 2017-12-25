package com.yandex.mail.autotest.webpages.client;

import com.yandex.mail.autotest.webelements.Element;
import com.yandex.mail.autotest.webelements.annotations.Locator;
import com.yandex.mail.autotest.webpages.BaseWebPage;
import com.yandex.mail.autotest.webpages.annotations.WebPage;
import org.openqa.selenium.WebElement;

@WebPage
public class LoginPage extends BaseWebPage<LoginPage> {

    @Locator(css = "input[name='login']")
    private Element usernameField;

    @Locator(css = "input[type='password']")
    private Element passwordField;

    @Locator(css = "button[type='submit']")
    private Element signInButton;

    public LoginPage inputUsername(String text)  {
        usernameField.fillWithText(text);
        return this;
    }

    public LoginPage inputPassword(String text)  {
        passwordField.fillWithText(text);
        return this;
    }

    public InboxPage clickSignInButton() {
        signInButton.click();
        return inboxPage;
    }
}
