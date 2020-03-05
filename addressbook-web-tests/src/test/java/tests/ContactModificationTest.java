package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification(){
        app.getSessionHelper().autoLogin("admin", "secret");
        app.getContactHelper().initContactEdition();
        app.getContactHelper().updateContactForm(new ContactDataParametrs("Dmitriy_edit", "Sergeevich_edit", "Romanov_edit", "arrnel_edit", "random title_edit", "Russia_edit", "+7(658)4853568", "random_edit@mail.org", "7", "June", "1989"));
        app.getContactHelper().updateButton();
        app.getNavigationHelper().gotoMainPage();
        app.getSessionHelper().logout();
    }

}
