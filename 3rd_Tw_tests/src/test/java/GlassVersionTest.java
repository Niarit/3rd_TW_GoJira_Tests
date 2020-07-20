import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.GlassPage;
import pages.ReleasesPage;
import tests.BaseTest;


public class GlassVersionTest {

    private final BaseTest baseTest = new BaseTest();

    @BeforeEach
    public void start(){
        baseTest.setup();
        baseTest.loginToJira();
    }

    @Test
    public void addNewVersionWithName(){
        ReleasesPage releasesPage = new ReleasesPage(baseTest.getDriver());
        releasesPage.navigateToPP1ReleasePage();
        releasesPage.addVersionName("GoJira Test");
        releasesPage.clickAddBtn();
        GlassPage glassPage = new GlassPage(baseTest.getDriver());
        glassPage.navigateToGlassPage();
        glassPage.navigateToGlassVersions();
        Assertions.assertEquals("GoJira Test", glassPage.getLatestReleaseName());
        releasesPage.navigateToPP1ReleasePage();
        releasesPage.deleteRelease();
    }

    @Test
    public void editExistingRelease(){
        ReleasesPage releasesPage = new ReleasesPage(baseTest.getDriver());
        releasesPage.navigateToPP1ReleasePage();
        releasesPage.addVersionName("GoJira Test");
        releasesPage.clickAddBtn();
        releasesPage.clickEdit();
        releasesPage.renameVersion("GoJira Test v1.0");
        releasesPage.confirmEdit();
        GlassPage glassPage = new GlassPage(baseTest.getDriver());
        glassPage.navigateToGlassPage();
        glassPage.navigateToGlassVersions();
        Assertions.assertEquals("GoJira Test v1.0", glassPage.getLatestReleaseName());
        releasesPage.navigateToPP1ReleasePage();
        releasesPage.deleteRelease();
    }

    @AfterEach
    public void closeDriver(){
        baseTest.close();
    }

}
