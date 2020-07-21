import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.GlassPage;
import pages.PrivateProjectPage;

import java.net.MalformedURLException;
import java.util.List;

public class GlassPermissionTest{

    private final BaseTest baseTest = new BaseTest();
    private BasePage basePage;

    public GlassPermissionTest() throws MalformedURLException {
    }

    @BeforeEach
    public void start() throws MalformedURLException {
        basePage = BasePage.getInstanceOfBasePage();
        basePage.setup();
        baseTest.loginToJira();
    }

    @Test
    public void checkPermissions() throws MalformedURLException {
        PrivateProjectPage privateProjectPage = new PrivateProjectPage();
        privateProjectPage.navigateToPP1Permissions();
        List<String> permissions = privateProjectPage.getPermissions();
        GlassPage glassPage = new GlassPage();
        glassPage.navigateToGlassPage();
        glassPage.navigateToGlassPermissions();
        List<String> glassPermissions = glassPage.getGlassPermissions();
        Assertions.assertEquals(permissions,glassPermissions);
    }

    @AfterEach
    public void closeDriver(){
        basePage.closeDriver();
    }
}
