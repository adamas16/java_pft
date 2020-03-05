package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification(){
        app.getSessionHelper().autoLogin("admin", "secret");
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().submitGroupEdition();
        app.getGroupHelper().fillGroupForm(new GroupDataParametrs("test1", "test2_edited", "test3_edited"));
        app.getContactHelper().updateButton();
        app.getNavigationHelper().returnToGroupPage();
        app.getSessionHelper().logout();
    }

}
