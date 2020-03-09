package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase{

    public List<ContactDataParametrs> contactCountBefore;
    public List<ContactDataParametrs> contactCountAfter;

    @Test
    public void testContactCreation() throws Exception{
//      Получаем количество контактов
        contactCountBefore = app.getContactHelper().getContactList();

//      добавляем контакт
        app.getContactHelper().initContactCreation();

        ContactDataParametrs contact = new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954");

//      заполнение формы
        app.getContactHelper().fillContactForm(contact, true);

//      нажать на подтверждение создание контакта
        app.getContactHelper().submitContactCreation();

//      возврат на главную страницу
        app.getNavigationHelper().gotoMainPage();

//      Получаем количество групп
        contactCountAfter = app.getContactHelper().getContactList();

//      Проверяем количество контактов до и после
        Assert.assertEquals(contactCountBefore.size(), contactCountAfter.size() - 1);

        contactCountBefore.add(contact);
        int max = 0;
        for(ContactDataParametrs c : contactCountAfter){
            if(c.getId()>max){
                max = c.getId();
            }
        }
        contact.setId(max);
        Assert.assertEquals(new HashSet<Object>(contactCountBefore), new HashSet<Object>(contactCountAfter));

//      выход из аккаунта
        app.getSessionHelper().logout();
    }



}
