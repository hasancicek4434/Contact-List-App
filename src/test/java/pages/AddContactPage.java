package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContactPage {
    private WebDriver driver;

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By submit = By.id("submit");

    public AddContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addContact(String fName, String lName) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(submit).click();
    }

    public boolean isContactAdded(String fName) {
        return driver.getPageSource().contains(fName);
    }
}
