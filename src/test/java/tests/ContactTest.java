package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.UUID;


public class ContactTest extends BaseTest {

    @Test
    public void testSignupLogoutAndLoginAndAddContact() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String email = "testuser_" + UUID.randomUUID() + "@mail.com";
        String password = "Password123!";
        String firstName = "Hasan";
        String lastName = "Cicek";

        // Sign Up
        SignUpPage signUp = new SignUpPage(driver);
        signUp.goToSignUp();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        signUp.signUp("Hasan", "Cicek", email, password);

        Assert.assertEquals(driver.getTitle(), "Add User");


        // Verification - logged in?
        ContactPage contactPage = new ContactPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-contact")));

        Assert.assertTrue(contactPage.isAt(), "The contact page did not open after sign up!");

        // Logout
        contactPage.logout();

        Assert.assertEquals(driver.getTitle(), "Contact List App");
        Assert.assertTrue(driver.getCurrentUrl().contains("https://thinking-tester-contact-list.herokuapp.com/"), "The login page did not open after logout!");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        loginPage.login(email, password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-contact")));
        Assert.assertTrue(contactPage.isAt(), "The contact page did not open after login!");

        //Adding a new contact
        contactPage.clickAddContact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        AddContactPage addContactPage = new AddContactPage(driver);
        addContactPage.addContact(firstName, lastName);

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), firstName));
        Assert.assertTrue(addContactPage.isContactAdded(firstName), "Could not add new contact!");
    }

    @Test
    public void testInvalidLoginWithWrongCredentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        LoginPage loginPage = new LoginPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        loginPage.login("wrong@email.com", "wrongpass");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        String errorText = driver.findElement(By.id("error")).getText();
        Assert.assertTrue(errorText.contains("Incorrect"), "Beklenen hata mesajı görünmedi!");

        Assert.assertFalse(driver.getCurrentUrl().contains("contactList"), "Yanlış bilgilerle contact sayfasına geçilmemeli!");
    }
}
