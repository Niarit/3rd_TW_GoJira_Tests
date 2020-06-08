package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoalaProjectPage {

    private final WebDriver driver;
    private final String projectUrl;
    private final By projectName = By.xpath("//*[@id='content']/div[1]/div/div[1]/header/div/div[2]/h1/div/div/a");


    public CoalaProjectPage(WebDriver driver) {
        this.driver = driver;
        this.projectUrl = "https://jira.codecool.codecanvas.hu/projects/COALA/";
    }

    public void navigateToProjectPage() {
        driver.navigate().to(projectUrl);
    }


}
