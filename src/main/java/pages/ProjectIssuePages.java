package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.List;


public class ProjectIssuePages {
    private BasePage basePage;
    @FindBy(id = "key-val") private WebElement issueName;
    @FindAll(@FindBy(id = "edit-issue")) private List<WebElement> editBtn;

    public ProjectIssuePages() throws MalformedURLException {
        this.basePage = BasePage.getInstanceOfBasePage();
        PageFactory.initElements(basePage.getDriver(), this);
    }

    public String getIssueName(){
        return issueName.getText();
    }


    public boolean checkForPageTitle(){
        return basePage.getDriver().findElements(By.id("summary-val")).size() != 0;
    }

    public void isEditBtnPresent(){
        Assertions.assertEquals(1, editBtn.size());
    }

}
