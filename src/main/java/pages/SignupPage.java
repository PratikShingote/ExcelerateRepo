package pages;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	
	public class SignupPage {
	    private WebDriver driver;

	    // Locators (update after inspecting)
	    private By nameField = By.id("name");
	    private By emailField = By.id("email");
	    private By passwordField = By.id("password");
	    private By confirmPasswordField = By.id("confirmPassword");
	    private By registerButton = By.xpath("//button[contains(text(), 'Register')]");
	    private By errorMessages = By.cssSelector(".error-message"); // adjust as needed

	    public SignupPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void open() {
	        driver.get("https://dev.4excelerate.net/auth/registration");
	    }

	    public void enterName(String name) {
	        driver.findElement(nameField).clear();
	        driver.findElement(nameField).sendKeys(name);
	    }

	    public void enterEmail(String email) {
	        driver.findElement(emailField).clear();
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String pwd) {
	        driver.findElement(passwordField).clear();
	        driver.findElement(passwordField).sendKeys(pwd);
	    }

	    public void enterConfirmPassword(String pwd) {
	        driver.findElement(confirmPasswordField).clear();
	        driver.findElement(confirmPasswordField).sendKeys(pwd);
	    }

	    public void clickRegister() {
	        driver.findElement(registerButton).click();
	    }

	    public String getErrorMessage() {
	        // Return the first error message; adjust locator if multiple
	        return driver.findElement(errorMessages).getText();
	    }
	}


