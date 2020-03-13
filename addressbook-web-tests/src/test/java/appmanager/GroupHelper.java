package appmanager;

import addressbook_tests_parametrs.GroupDataParametrs;
import addressbook_tests_parametrs.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    private NavigationHelper goTo = new NavigationHelper(driver);
    private ContactHelper contactHelper = new ContactHelper(driver);

    private Groups groupCache;

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

    public void selectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='"+id+"'")).click();
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

    public void create(GroupDataParametrs groupDataParametrs) {
        initGroupCreation();
        fillGroupForm(groupDataParametrs);
        submitGroupCreation();
        goTo.returnToGroupPage();
        goTo.mainPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void exists(GroupDataParametrs group) {
        goTo.groupPage();
        if (!isThereAGroup()) {
            create(group);
        }
        contactHelper.gotoHomePage();
    }

    public int count() {
        return getElementsCount(By.xpath("//input[@name=\"selected[]\"]"));
    }

    public Groups all() {

        if (groupCache != null){
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name=element.getText();
            int  id=Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupDataParametrs().withId(id).withName(name));
        }
        return new Groups (groupCache);
    }


    public void modifyGroup (GroupDataParametrs group) {

//      выбор группы
        selectGroupById(group.getId());

//      нажатие на кнопку изменить
        submitGroupEdition();

//      заполнение формы
        fillGroupForm(group);

//      подтверждение изменения
        contactHelper.updateButton();

        groupCache = null;

//      возврат на страницу с группами
        goTo.returnToGroupPage();
    }

    public void createGroup(GroupDataParametrs group) {
//      Нажатие на кнопку добавления группы
        initGroupCreation();

//      заполнение формы
        fillGroupForm(group);

//      Нажатие на кнопку создания группы
        submitGroupCreation();

        groupCache = null;

//      Возврат на страницу группы
        goTo.returnToGroupPage();
    }

    public void delete(int index) {
//      выбор группы
        selectGroup(index);

//      подтверждение удаления
        submitGroupDeletion();

//      возврат на страницу с группами
        goTo.returnToGroupPage();
    }

    public void delete(GroupDataParametrs group) {
        selectGroupById(group.getId());
        submitGroupDeletion();
        groupCache = null;
        goTo.returnToGroupPage();
    }
}
