package com.cloudshop.ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebFormPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By textInput = By.name("my-text");
    private final By submitButton = By.cssSelector("button");
    private final By resultMessage = By.id("message");

    public WebFormPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    public void open() {
        driver.get(
                "https://www.selenium.dev/selenium/web/web-form.html"
        );
    }

    public void enterText(String text) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(textInput)
        ).sendKeys(text);
    }

    public void submit() {
        wait.until(
                ExpectedConditions.elementToBeClickable(submitButton)
        ).click();
    }

    public String getResultMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(resultMessage)
        ).getText();
    }
}