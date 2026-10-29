package com.cloudshop.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver createDriver() {

        ChromeOptions options = new ChromeOptions();

        if (Boolean.parseBoolean(
                System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--window-size=1440,1000");

        return new ChromeDriver(options);
    }
}