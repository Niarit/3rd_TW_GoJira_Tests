package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReleasesPage {
    private final WebDriver driver;
    private final By versionNameField = By.xpath("//input[@placeholder='Version name']");
    private final By startDateField = By.xpath("//input[@placeholder='Start date (optional)']");
    private final By releaseDateField = By.xpath("//input[@placeholder='Release date (optional)']");
    private final By descriptionField = By.xpath("//input[@placeholder='Description (optional)']");
    private final By addBtn = By.xpath("//button[@class='aui-button aui-button-primary']");

    public ReleasesPage(WebDriver driver) {
        this.driver = driver;
    }
}
