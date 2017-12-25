package com.yandex.mail.autotest.webpages.client;

import com.yandex.mail.autotest.webelements.annotations.Locator;
import com.yandex.mail.autotest.webpages.BaseWebPage;
import com.yandex.mail.autotest.webpages.annotations.WebPage;
import org.openqa.selenium.WebElement;

@WebPage
public abstract class AbstractEmailClientPage<T> extends BaseWebPage<T> {

    @Locator(css = "a.mail-NestedList-Item[href='#inbox']")
    protected WebElement inboxLink;

    @Locator(css = "a.mail-ComposeButton")
    protected WebElement composeButton;

    public InboxPage clickInboxLink()  {
        inboxLink.click();
        return inboxPage;
    }

    public ComposeEmailPage clickComposeButton()  {
        composeButton.click();
        return composeEmailPage;
    }

}
