package tests;



import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SignupPage;
import utils.TestListener;
@Listeners(TestListener.class)
public class SignupTest extends BaseTest {

    @Test
    public void signupWithValidDetails() {
        SignupPage signup = new SignupPage(driver);
        signup.open();
        signup.enterName("Test User");
        signup.enterEmail("testuser123@example.com");
        signup.enterPassword("ValidPass123!");
        signup.enterConfirmPassword("ValidPass123!");
        signup.clickRegister();

        // Example: either redirected or success message
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/dashboard") || currentUrl.contains("/login"), "User should be redirected after successful registration");
        // Optionally check for success message
    }

    @Test
    public void signupWithExistingEmail() {
        SignupPage signup = new SignupPage(driver);
        signup.open();
        signup.enterName("Another User");
        signup.enterEmail("existinguser@example.com");
        signup.enterPassword("ValidPass123!");
        signup.enterConfirmPassword("ValidPass123!");
        signup.clickRegister();

        String err = signup.getErrorMessage();
        Assert.assertTrue(err.contains("already exists") || err.toLowerCase().contains("taken"), "Appropriate error should be shown for existing email");
    }
}

