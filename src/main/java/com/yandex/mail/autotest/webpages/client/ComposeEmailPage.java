package com.yandex.mail.autotest.webpages.client;

import com.yandex.mail.autotest.webelements.Element;
import com.yandex.mail.autotest.webelements.annotations.Locator;
import com.yandex.mail.autotest.webpages.BaseWebPage;
import com.yandex.mail.autotest.webpages.annotations.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@WebPage
public class ComposeEmailPage extends BaseWebPage<ComposeEmailPage> {

    @Locator(css = "div.ns-view-compose-field-to .js-compose-field")
    private Element toField;

    @Locator(css = "div.ns-view-compose-field-cc .js-compose-field")
    private Element ccField;

    @Locator(css = "input[name='subj']")
    private Element subjectField;

    @Locator(css = "div.cke_contents>div")
    private Element bodyField;

    @Locator(css = "button[type='submit']")
    private WebElement sendButton;

    @Locator(css = "div.ns-view-done")
    private Element emailSuccessBlock;


    public ComposeEmailPage clickSendButton() {
        sendButton.click();
        return this;
    }

    public ComposeEmailPage inputTo(String text) {
        toField.fillWithText(text);
        return this;
    }

    public ComposeEmailPage inputCc(String text) {
        ccField.sendKeys(text);
        return this;
    }

    public ComposeEmailPage inputSubject(String text) {
        subjectField.fillWithText(text);
        return this;
    }

    public ComposeEmailPage inputBody(String text) {
        bodyField.fillWithText(text);
        return this;
    }

    public boolean isEmailSuccessBlockPresent(){
        return emailSuccessBlock.isPresent();
    }
}
