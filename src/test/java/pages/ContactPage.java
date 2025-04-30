package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
    private WebDriver driver;

    private By addContactButton = By.id("add-contact");

    private By logoutButton = By.xpath("//button[text()='Logout']");

    public void logout() {
        driver.findElement(logoutButton).click();
    }

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAt() {
        return driver.findElement(addContactButton).isDisplayed();
    }

    public void clickAddContact() {
        driver.findElement(addContactButton).click();
    }

}
