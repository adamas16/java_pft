package appmanager;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroup(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
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

    public int groupCount() {
        return getElementsCount(By.xpath("//input[@name=\"selected[]\"]"));
    }

    public List<GroupDataParametrs> getGroupList() {
        List <GroupDataParametrs> groups = new ArrayList <GroupDataParametrs>();
        List <WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupDataParametrs group = new GroupDataParametrs(id, name, null,null);
            groups.add(group);
        }
        return groups;
    }
    public void modifyGroup(int index, GroupDataParametrs group) {

//      выбор группы
        selectGroup(index);

//      нажатие на кнопку изменить
        submitGroupEdition();

//      заполнение формы
        fillGroupForm(group);

//      подтверждение изменения
        contactHelper.updateButton();

//      возврат на страницу с группами
        navigationHelper.returnToGroupPage();
    }
}
