package com.yandex.mail.autotest.webpages.client;

import com.yandex.mail.autotest.webdriver.Driver;
import com.yandex.mail.autotest.webelements.annotations.Locator;
import com.yandex.mail.autotest.webpages.BaseWebPage;
import com.yandex.mail.autotest.webpages.annotations.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@WebPage
public abstract class AbstractEmailClientPage<T> extends BaseWebPage<T> {

    @Locator(css = "a.mail-NestedList-Item[href='#inbox']")
    protected WebElement inboxLink;

    @Locator(css = "a.mail-ComposeButton")
    protected WebElement composeButton;

    @Locator(css = "div.mail-Toolbar-Item_delete")
    protected WebElement deleteButton;

    public InboxPage clickInboxLink()  {
        inboxLink.click();
        return inboxPage;
    }

    public ComposeEmailPage clickComposeButton() {
        composeButton.click();
        return composeEmailPage;
    }

    public AbstractEmailClientPage clickDeleteButton() {
        deleteButton.click();
        return this;
    }

    public AbstractEmailClientPage selectEmailBySubject(String subject) {
        Driver.getDriver().findElement(By.xpath("//span[text()='" + subject + "']/ancestor::div[@class='mail-MessageSnippet-Content']//input[@type='checkbox']"));
        return this;
    }

}
