package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase{

    public static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception{
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        //      выход из аккаунта
        app.getSessionHelper().logout();

        app.stop();
    }
}
