package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReleasesPage {
    private WebDriver driver;
    private By versionNameField = By.xpath("//input[@placeholder='Version name']");
    private By startDateField = By.xpath("//input[@placeholder='Start date (optional)']");
    private By releaseDateField = By.xpath("//input[@placeholder='Release date (optional)']");
    private By descriptionField = By.xpath("//input[@placeholder='Description (optional)']");
    private By addBtn = By.xpath("//button[@class='aui-button aui-button-primary']");

    public ReleasesPage(WebDriver driver) {
        this.driver = driver;
    }
}
