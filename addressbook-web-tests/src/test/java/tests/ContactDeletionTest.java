package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase{

    public List<ContactDataParametrs> contactCountBefore;
    public List<ContactDataParametrs> contactCountAfter;
    @Test
    public void testContactDeletion(){
//        проверка наличия контакта
        if(!app.getContactHelper().isThereAContact()){

//          создание группы при её отсутствии
            app.getGroupHelper().checkGroupExists(new GroupDataParametrs("test1", "test2", "test3"));

//          создание контакта при его отсутствии
            app.getContactHelper().createContact(new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954"), true);
            System.out.println("Контакт создан");
        }

//      Получаем количество контактов
        contactCountBefore = app.getContactHelper().getContactList();

//      выбор контакта
        app.getContactHelper().selectContact(contactCountBefore.size() - 1);

//      нажатие на кнопку удаления контакта
        app.getContactHelper().submitContactDeletion();

//      возврат на главную страницу
        app.getNavigationHelper().gotoMainPage();

//      Получаем количество контактов
        contactCountAfter = app.getContactHelper().getContactList();

//      Проверяем количество контактов до и после
        Assert.assertEquals(contactCountBefore.size(), contactCountAfter.size() + 1);

        contactCountBefore.remove(contactCountBefore.size() -1);
        Assert.assertEquals(contactCountBefore,contactCountAfter);
    }

}
