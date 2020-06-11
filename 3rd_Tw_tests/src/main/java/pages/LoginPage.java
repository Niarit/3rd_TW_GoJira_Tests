package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    @FindBy(id = "login-form-username") private WebElement usernameField;
    @FindBy(id = "login-form-password") WebElement passwordField;
    @FindBy(id = "login") private WebElement loginBtn;
    @FindBy(id = "usernameerror") private WebElement loginError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logIntoJira(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-username")));
        usernameField.click();
        usernameField.sendKeys(username);
        passwordField.click();
        passwordField.sendKeys(password);
        loginBtn.click();
    }

    public void checkError(){
        String errorMsg = loginError.getText();
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.", errorMsg);
    }

}
