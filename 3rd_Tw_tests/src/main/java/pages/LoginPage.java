package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By usernameField = By.id("login-form-username");
    private final By passwordField = By.id("login-form-password");
    private final By loginBtn = By.id("login");
    private final By loginError = By.id("usernameerror");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIntoJira(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public void checkError(){
        String errorMsg = driver.findElement(loginError).getText();
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.", errorMsg);
    }

}
