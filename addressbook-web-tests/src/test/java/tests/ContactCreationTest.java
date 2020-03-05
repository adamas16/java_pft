package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        app.getSessionHelper().autoLogin("admin", "secret");
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoMainPage();
        app.getSessionHelper().logout();
    }



}
