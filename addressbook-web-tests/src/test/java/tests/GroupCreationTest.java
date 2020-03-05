package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreationTests() throws Exception {
        app.getSessionHelper().autoLogin("admin", "secret");
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupDataParametrs("test1", null, null));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().returnToGroupPage();
        app.getSessionHelper().logout();
    }

}