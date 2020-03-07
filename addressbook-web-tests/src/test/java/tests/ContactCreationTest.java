package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
//      добавляем контакт
        app.getContactHelper().initContactCreation();
//      заполнение формы
        app.getContactHelper().fillContactForm(new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954"), true);
//      нажать на подтверждение создание контакта
        app.getContactHelper().submitContactCreation();
//      возврат на главную страницу
        app.getNavigationHelper().gotoMainPage();
//      выход из аккаунта
        app.getSessionHelper().logout();
    }



}
