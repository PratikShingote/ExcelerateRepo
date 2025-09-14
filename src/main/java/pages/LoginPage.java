package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMsg = By.cssSelector(".error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMsg).getText();
        } catch (Exception e) {
            return "";
        }
    }
}