package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainTestingProjectPage {

    private final WebDriver driver;
    private final By projectName = By.xpath("//*[@id='content']/div[1]/div/div[1]/header/div/div[2]/h1/div/div/a");

    public MainTestingProjectPage(WebDriver driver) {
        this.driver = driver;
    }


}
