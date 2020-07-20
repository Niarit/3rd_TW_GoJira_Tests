import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.GlassPage;
import pages.PrivateProjectPage;
import tests.BaseTest;

import java.util.List;

public class GlassPermissionTest{

    private final BaseTest baseTest = new BaseTest();

    @BeforeEach
    public void start(){
        baseTest.setup();
        baseTest.loginToJira();
    }

    @Test
    public void checkPermissions(){
        PrivateProjectPage privateProjectPage = new PrivateProjectPage(baseTest.getDriver());
        privateProjectPage.navigateToPP1Permissions();
        List<String> permissions = privateProjectPage.getPermissions();
        GlassPage glassPage = new GlassPage(baseTest.getDriver());
        glassPage.navigateToGlassPage();
        glassPage.navigateToGlassPermissions();
        List<String> glassPermissions = glassPage.getGlassPermissions();
        Assertions.assertEquals(permissions,glassPermissions);
    }

    @AfterEach
    public void closeDriver(){
        baseTest.close();
    }
}
