package tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion()  throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().submitGroupDeletion();
        app.getNavigationHelper().returnToGroupPage();
        app.getSessionHelper().logout();
    }

}
