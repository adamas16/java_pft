package appmanager;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper {

    private WebDriver driver;

    public GroupHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void fillGroupForm(GroupDataParametrs groupDataParametrs) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupDataParametrs.getName());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupDataParametrs.getHeader());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupDataParametrs.getFooter());
    }

    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void submitGroupDeletion() {
        driver.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

}
