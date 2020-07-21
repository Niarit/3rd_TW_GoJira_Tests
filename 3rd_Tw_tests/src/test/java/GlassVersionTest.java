import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.GlassPage;
import pages.ReleasesPage;

import java.net.MalformedURLException;


public class GlassVersionTest {

    private final BaseTest baseTest = new BaseTest();
    private BasePage basePage;

    public GlassVersionTest() throws MalformedURLException {
    }

    @BeforeEach
    public void start() throws MalformedURLException {
        basePage = BasePage.getInstanceOfBasePage();
        basePage.setup();
        baseTest.loginToJira();
    }

    @Test
    public void addNewVersionWithName() throws MalformedURLException {
        ReleasesPage releasesPage = new ReleasesPage();
        releasesPage.navigateToPP1ReleasePage();
        releasesPage.addVersionName("GoJira Test");
        releasesPage.clickAddBtn();
        GlassPage glassPage = new GlassPage();
        glassPage.navigateToGlassPage();
        glassPage.navigateToGlassVersions();
        Assertions.assertEquals("GoJira Test", glassPage.getLatestReleaseName());
        releasesPage.navigateToPP1ReleasePage();
        releasesPage.deleteRelease();
    }

    @Test
    public void editExistingRelease() throws MalformedURLException {
        ReleasesPage releasesPage = new ReleasesPage();
        releasesPage.navigateToPP1ReleasePage();
        releasesPage.addVersionName("GoJira Test");
        releasesPage.clickAddBtn();
        releasesPage.clickEdit();
        releasesPage.renameVersion("GoJira Test v1.0");
        releasesPage.confirmEdit();
        GlassPage glassPage = new GlassPage();
        glassPage.navigateToGlassPage();
        glassPage.navigateToGlassVersions();
        Assertions.assertEquals("GoJira Test v1.0", glassPage.getLatestReleaseName());
        releasesPage.navigateToPP1ReleasePage();
        releasesPage.deleteRelease();
    }

    @AfterEach
    public void closeDriver(){
        basePage.closeDriver();
    }

}
