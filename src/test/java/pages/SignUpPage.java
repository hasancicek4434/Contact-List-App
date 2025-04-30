package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    private By signupLink = By.id("signup");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By submitButton = By.id("submit");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToSignUp() {
        driver.findElement(signupLink).click();
    }

    public void signUp(String fName, String lName, String emailStr, String pass) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(emailStr);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submitButton).click();
    }
}

