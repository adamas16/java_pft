package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    public int contactCountBefore;
    public int contactCountAfter;

    @Test
    public void testContactDeletion() throws Exception {
//        проверка наличия контакта
        if(!app.getContactHelper().isThereAContact()){

//          создание группы при её отсутствии
            app.getGroupHelper().checkGroupExists(new GroupDataParametrs("test1", "test2", "test3"));

//          создание контакта при его отсутствии
            app.getContactHelper().createContact(new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954"), true);
            System.out.println("Контакт создан");
        }

//      Получаем количество контактов
        contactCountBefore = app.getGroupHelper().groupCount();

//      выбор контакта
        app.getContactHelper().selectContact(contactCountBefore - 1);

//      нажатие на кнопку удаления контакта
        app.getContactHelper().submitContactDeletion();

//      возврат на главную страницу
        app.getNavigationHelper().gotoMainPage();

//      Получаем количество контактов
        contactCountAfter = app.getGroupHelper().groupCount();

//      Проверяем количество контактов до и после
        Assert.assertEquals(contactCountAfter, contactCountBefore - 1);

//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}
