package com.pom.letskodeit;

import com.basepage.AbstractBasePage;
import com.testcases.LoginTest;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class LoginPage extends AbstractBasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /***
    * Locators
    * */
    //private By emailField = By.xpath("//*[@id='user_email']");
    //private By passWordField = By.xpath("//*[@id='user_password']");
    //private By submitButton = By.xpath("//*[@type='submit']");

    @FindBy(xpath = "//*[@id='user_email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='user_password']")
    private WebElement passWordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;



    /***
     * Method
     */

    public void login(String email, String password) {
        sendKeyToTextBox(emailField, email);
        sendKeyToTextBox(passWordField, password);
        clickElement(submitButton);
    }


}
