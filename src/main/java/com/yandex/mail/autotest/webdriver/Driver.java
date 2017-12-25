package com.yandex.mail.autotest.webdriver;


import com.yandex.mail.autotest.spring.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class Driver {

    private static final String PATH_TO_DRIVERS = "src/main/resources/drivers/";

    private static ThreadLocal<WebDriver> driver  = new ThreadLocal<>();
    private static Set<WebDriver> allDrivers = new HashSet<>();

    private static String driverName;

    public static WebDriver getDriver() {
        if (driver.get() == null) initDriver();
        return driver.get();
    }

    private static void initDriver() {
        switch (driverName) {
            case "chrome" : setUpChromeDriver(); break;
            case "firefox" : setUpFirefoxDriver(); break;
        }
    }

    public static void killDriver() {
        driver.get().quit();
        driver.set(null);
    }

    private static void setUpChromeDriver() {
        WebDriver newDriver = new ChromeDriver();
        newDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.set(newDriver);
        allDrivers.add(newDriver);
    }

    private static void setUpFirefoxDriver() {
        WebDriver newDriver = new FirefoxDriver();
        newDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.set(newDriver);
        allDrivers.add(newDriver);
    }

    @PostConstruct
    private void postConstruct() {
        driverName = Context.get().getEnvironment().getProperty("driver");
        System.setProperty("webdriver.gecko.driver", PATH_TO_DRIVERS + "geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVERS + "chromedriver.exe");
    }

    @PreDestroy
    private void preDestroy() {
        allDrivers.forEach(WebDriver::quit);
    }
}
