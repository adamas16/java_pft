package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase{

    public List<ContactDataParametrs> contactCountBefore;
    public List<ContactDataParametrs> contactCountAfter;

    @BeforeMethod
    public void ensurePreconditions() {
//      проверка наличия контакта
        if(!app.getContactHelper().isThereAContact()){
//      создание группы при её отсутствии
            app.getGroupHelper().checkGroupExists(new GroupDataParametrs("test1", "test2", "test3"));
//      создание контакта при его отсутствии
            app.getContactHelper().createContact(new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954"), true);
        }
    }

    @Test
    public void testContactModification(){

//      Получаем количество контактов
        contactCountBefore = app.getContactHelper().getContactList();

//      Индекс контакта
        int index = contactCountBefore.size() - 1;

        ContactDataParametrs contact = new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954");

        app.getContactHelper().modifyContact(index, contact);

//      Получаем количество групп
        contactCountAfter = app.getContactHelper().getContactList();

//      Проверяем количество контактов до и после
        Assert.assertEquals(contactCountBefore.size(), contactCountAfter.size());

        contactCountBefore.remove(index);

        contactCountBefore.add(contact);

        Assert.assertEquals(new HashSet<Object>(contactCountBefore), new HashSet<Object>(contactCountAfter));
    }

}
