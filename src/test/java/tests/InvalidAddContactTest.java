package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ContactPage;
import pages.SignUpPage;
import pages.AddContactPage;

import java.time.Duration;
import java.util.UUID;

public class InvalidAddContactTest extends BaseTest {

    @BeforeMethod
    public void setUpUserAndLogin() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String email = "user_" + UUID.randomUUID() + "@mail.com";
        String password = "Password123!";

        SignUpPage signUp = new SignUpPage(driver);
        signUp.goToSignUp();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        signUp.signUp("Hasan", "Cicek", email, password);

        wait.until(ExpectedConditions.urlContains("contact"));
        ContactPage contactPage = new ContactPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-contact")));
        contactPage.clickAddContact();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
    }

    @Test
    public void testAddContactWithEmptyFields() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        AddContactPage addContactPage = new AddContactPage(driver);
        addContactPage.addContact("", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        Assert.assertTrue(driver.findElement(By.id("error")).getText().contains("Contact validation failed"));
        Assert.assertTrue(driver.getCurrentUrl().contains("addContact"));
    }

    @Test
    public void testAddContactWithOnlyFirstName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        AddContactPage addContactPage = new AddContactPage(driver);
        addContactPage.addContact("Hasan", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        Assert.assertTrue(driver.findElement(By.id("error")).getText().contains("Contact validation failed"));
        Assert.assertTrue(driver.getCurrentUrl().contains("addContact"));
    }

    @Test
    public void testAddContactWithOnlyLastName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        AddContactPage addContactPage = new AddContactPage(driver);
        addContactPage.addContact("", "Cicek");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        Assert.assertTrue(driver.findElement(By.id("error")).getText().contains("Contact validation failed"));
        Assert.assertTrue(driver.getCurrentUrl().contains("addContact"));
    }
}

