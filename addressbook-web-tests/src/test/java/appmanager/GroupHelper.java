package appmanager;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    private NavigationHelper navigationHelper = new NavigationHelper(driver);
    private ContactHelper contactHelper = new ContactHelper(driver);

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void fillGroupForm(GroupDataParametrs groupDataParametrs) {

        type(By.name("group_name"), groupDataParametrs.getName());
        type(By.name("group_header"), groupDataParametrs.getHeader());
        type(By.name("group_footer"), groupDataParametrs.getFooter());
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void submitGroupDeletion() {
        click(By.xpath("(//input[@name='delete'])[2]"));
    }

    public void submitGroupEdition() {
        click(By.xpath("(//input[@name='edit'])[2]"));
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void createGroup(GroupDataParametrs groupDataParametrs) {
        initGroupCreation();
        fillGroupForm(groupDataParametrs);
        submitGroupCreation();
        navigationHelper.returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void checkGroupExists(GroupDataParametrs group) {
        navigationHelper.gotoGroupPage();
        if (!isThereAGroup()) {
            createGroup(group);
        }
        contactHelper.gotoHomePage();
    }
}
