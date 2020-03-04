import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.TestBase;

import java.util.concurrent.TimeUnit;

public class ContactDeletionTest extends TestBase{

    @Test
    public void testContactDeletion(){
        autoLogin("admin", "secret");
        selectContact();
        submitContactDeletion();
        gotoMainPage();
        logout();
    }

    public void submitContactDeletion(){
        driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
        driver.switchTo().alert().accept();
    }
}
