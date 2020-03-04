import addressbook_tests_parametrs.GroupDataParametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.TestBase;

import java.util.concurrent.TimeUnit;


public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreationTests() throws Exception {
        autoLogin("admin", "secret");
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupDataParametrs("test1", "test2", "test3"));
        submitGroupCreation();
        returnToGroupPage();
        logout();
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

}