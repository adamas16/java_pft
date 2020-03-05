package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{

    public WebDriver driver;

    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    public String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        String browser = BrowserType.GOOGLECHROME;
        if (browser.equals(BrowserType.GOOGLECHROME)){
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)){
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.IE)){
            driver = new InternetExplorerDriver();
        } else if (browser.equals(BrowserType.SAFARI)){
            driver = new SafariDriver();
        }

        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
