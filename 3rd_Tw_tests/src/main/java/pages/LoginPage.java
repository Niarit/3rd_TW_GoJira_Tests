package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class LoginPage {
    private BasePage basePage;
    @FindBy(id = "login-form-username") private WebElement usernameField;
    @FindBy(id = "login-form-password") WebElement passwordField;
    @FindBy(id = "login") private WebElement loginBtn;
    @FindBy(id = "usernameerror") private WebElement loginError;

    public LoginPage() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public void logIntoJira(String username, String password){
        WebDriverWait wait = new WebDriverWait(basePage.getDriver(), 5);
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
