package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainTestingProjectPage {
    private final WebDriver driver;
    private final By summery = By.id("summary-val");
    private final By editBtn = By.id("edit-issue");
    private final By editScreenSummery = By.id("summary");
    private final By updateBtn = By.id("edit-issue-submit");
    private final By cancel = By.xpath("//a[@class='cancel']");

    public MainTestingProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSummaryTo(String msg){
        driver.findElement(summery).click();
        driver.findElement(summery).sendKeys(msg);
    }

    public void checkSummary(){
        String currentSummary = driver.findElement(summery).getText();
        Assertions.assertEquals("sfdg, a fine juicy apple - test",currentSummary);
    }

    public void clickEdit(){
        driver.findElement(editBtn).click();
    }

    public void setSummeryOnEditScreen(String msg){
        WebElement summery = driver.findElement(editScreenSummery);
        summery.click();
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
