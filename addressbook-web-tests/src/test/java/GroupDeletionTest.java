import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.TestBase;


public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion()  throws Exception {
        autoLogin("admin", "secret");
        gotoGroupPage();
        selectGroup();
        submitGroupDeletion();
        returnToGroupPage();
        logout();
    }

    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void submitGroupDeletion() {
        driver.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
    }
}
