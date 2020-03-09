package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactModificationTest extends TestBase{

    public List<ContactDataParametrs> contactCountBefore;
    public List<ContactDataParametrs> contactCountAfter;


    @Test
    public void testContactModification() throws InterruptedException {
//      проверка наличия контакта
        if(!app.getContactHelper().isThereAContact()){
//      создание группы при её отсутствии
            app.getGroupHelper().checkGroupExists(new GroupDataParametrs("test1", "test2", "test3"));
//      создание контакта при его отсутствии
            app.getContactHelper().createContact(new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954"), true);
        }

//      Получаем количество контактов
//      contactCountBefore = app.getGroupHelper().groupCount();
        contactCountBefore = app.getContactHelper().getContactList();

//      нажатие на кнопку редактировать
        app.getContactHelper().initContactEdition(contactCountBefore.size() - 1);

//      заполнение формы
        app.getContactHelper().fillContactForm(new ContactDataParametrs("Dmitriy_edit", "Sergeevich_edit", "Romanov_edit", "arrnel_edit", "random title_edit", "Russia_edit", "+7(658)4853568", "random_edit@mail.org", "7", "June", "1989"),false);

//      нажать на обновить контакт
        app.getContactHelper().updateButton();

//      возврат на главную страницу
        app.getNavigationHelper().gotoMainPage();

//      Получаем количество групп
//      contactCountAfter = app.getGroupHelper().groupCount();
        contactCountAfter = app.getContactHelper().getContactList();

//      Проверяем количество контактов до и после
        Assert.assertEquals(contactCountBefore.size(), contactCountAfter.size());


//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}
