package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("valid@example.com", "ValidPass123!");
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"), "User should land on dashboard.");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid@example.com", "WrongPass");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"), "Error message should appear.");
    }
}