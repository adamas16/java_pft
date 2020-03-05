package tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    @Test
    public void testContactDeletion() throws Exception {
        app.getSessionHelper().autoLogin("admin", "secret");
        app.getContactHelper().selectContact();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().gotoMainPage();
        app.getSessionHelper().logout();
    }

}
