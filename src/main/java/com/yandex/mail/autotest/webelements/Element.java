package com.yandex.mail.autotest.webelements;


import com.yandex.mail.autotest.webdriver.Driver;
import org.openqa.selenium.*;

import java.util.List;

public class Element implements WebElement {

    private By locator;

    public Element(By locator) {
        this.locator = locator;
    }

    public void fillWithText(String text) {
        WebElement element = find();
        element.clear();
        element.sendKeys(text);
    }

    public boolean isPresent() {
        try {
            return find().isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    @Override
    public void click() {
        find().click();
    }

    @Override
    public void submit() {
        find().submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        find().sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        find().clear();
    }

    @Override
    public String getTagName() {
        return find().getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return find().getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return find().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return find().isEnabled();
    }

    @Override
    public String getText() {
        return find().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return find().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return find().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return find().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return find().getLocation();
    }

    @Override
    public Dimension getSize() {
        return find().getSize();
    }

    @Override
    public Rectangle getRect() {
        return find().getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return find().getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return find().getScreenshotAs(target);
    }

    private WebElement find() {
        return Driver.getDriver().findElement(locator);
    }

}