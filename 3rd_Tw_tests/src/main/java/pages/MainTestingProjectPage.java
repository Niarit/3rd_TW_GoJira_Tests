package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTestingProjectPage {
    private final WebDriver driver;
    private final By summeryEditBtn = By.xpath("//h1[@id='summary-val']//span[@class='overlay-icon aui-icon aui-icon-small aui-iconfont-edit']");
    private final By summery = By.id("summary-val");
    private final By editBtn = By.id("edit-issue");
    private final By editScreenSummery = By.id("summary");
    private final By updateBtn = By.xpath("//input[@id='issue-edit-submit']");
    private final By cancel = By.id("issue-edit-cancel");

    public MainTestingProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSummaryTo(String msg){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(summery));
        driver.findElement(summeryEditBtn).click();
        WebElement summeryField = driver.findElement(By.id("summary"));
        summeryField.sendKeys(Keys.DELETE);
        summeryField.sendKeys(msg);
        WebElement acceptBtn = driver.findElement(By.xpath("//button[@class='aui-button submit']"));
        acceptBtn.click();
    }

    public String getSummaryText(){
        return driver.findElement(summery).getText();
    }

    public void clickEdit(){
        driver.findElement(editBtn).click();
    }

    public void setSummeryOnEditScreen(String msg){
        WebElement summery = driver.findElement(editScreenSummery);
        summery.sendKeys(Keys.DELETE);
        summery.sendKeys(msg);
    }

    public void clickUpdate(){
        driver.findElement(updateBtn).click();
    }

    public void clickCancel(){
        driver.findElement(cancel).click();
    }

}
