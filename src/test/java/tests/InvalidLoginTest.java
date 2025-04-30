package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void testInvalidLoginWithEmptyFields() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        LoginPage loginPage = new LoginPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        loginPage.login("", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        String errorText = driver.findElement(By.id("error")).getText();
        Assert.assertTrue(errorText.contains("Incorrect"));

        Assert.assertFalse(driver.getCurrentUrl().contains("contactList"));
    }

    @Test
    public void testInvalidLoginWithWrongCredentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        LoginPage loginPage = new LoginPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        loginPage.login("wrong@email.com", "wrongpass");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        String errorText = driver.findElement(By.id("error")).getText();
        Assert.assertTrue(errorText.contains("Incorrect"));

        Assert.assertFalse(driver.getCurrentUrl().contains("contactList"));
    }
}

