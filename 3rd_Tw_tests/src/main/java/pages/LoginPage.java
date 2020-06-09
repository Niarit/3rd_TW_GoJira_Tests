package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final By usernameField = By.id("login-form-username");
    private final By passwordField = By.id("login-form-password");
    private final By loginBtn = By.id("login");
    private final By loginError = By.id("usernameerror");
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIntoJira(String username, String password){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        WebElement usernameInput = driver.findElement(usernameField);
        WebElement passwordInput = driver.findElement(passwordField);
        usernameInput.click();
        usernameInput.sendKeys(username);
        passwordInput.click();
        passwordInput.sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public void checkError(){
        String errorMsg = driver.findElement(loginError).getText();
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.", errorMsg);
    }

}
