package com.web.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementWaits {
    final WebDriver driver;
    private static Logger LOGGER = LogManager.getLogger(WebElementWaits.class.getName());
    private final static int WAIT_TIMEOUT_DEFAULT = 10;
    private final static int MILISECOND_VALUE = 1000;
    final WebDriverWait wait;

    public WebElementWaits(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = createWebDriverWait(WAIT_TIMEOUT_DEFAULT);
    }

    private WebDriverWait createWebDriverWait(final long timeOutInSeconds) {
        return new WebDriverWait(driver, timeOutInSeconds);
    }

    public void staticWait(int seconds) throws InterruptedException {
        LOGGER.info("Static wait: " + seconds + "sec...");
        Thread.sleep(seconds * MILISECOND_VALUE);
    }

    /**
     * Waits for element to be visible within 30 sec
     *
     * @param webElement
     */
    protected void waitForElementToBeVisible(final WebElement webElement) {
        try {
            LOGGER.info("Try to Wait for element to be visible");
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("Element is not visible");
        }
    }

    /**
     * Waits for element to be visible within 30 sec
     *
     * @param elementLocator
     */
    protected void waitForElementToBeVisible(final By elementLocator) {
        try {
            LOGGER.info("Try to Wait for element to be visible");
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("Element is not visible");
        }
    }

    /**
     * Waits for text in Element to be visible within 10s
     * @param elementLocator
     * @param textInElement
     */
    protected void witForTextToBePresentInElementLocated(final By elementLocator, String textInElement){
        try{
            LOGGER.info("Try to Wait for text to be visible");
            wait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocator, textInElement));
        }catch (TimeoutException e){
            LOGGER.info("Text in Element is not visible");
        }
    }
}