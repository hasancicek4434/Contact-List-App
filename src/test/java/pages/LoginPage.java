package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By email = By.id("email");
    private By password = By.id("password");
    private By submit = By.id("submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String emailStr, String pass) {
        driver.findElement(email).sendKeys(emailStr);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();
    }
}
