package com.cloudshop.ui.tests;

import com.cloudshop.core.DriverFactory;
import com.cloudshop.ui.pages.WebFormPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WebFormTest {

    private WebDriver driver;
    private WebFormPage webFormPage;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createDriver();
        webFormPage = new WebFormPage(driver);
        webFormPage.open();
    }

    @Test
    void shouldSubmitTextSuccessfully() {

        webFormPage.enterText("CloudShop SDET");
        webFormPage.submit();

        assertEquals(
                "Received!",
                webFormPage.getResultMessage()
        );
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}