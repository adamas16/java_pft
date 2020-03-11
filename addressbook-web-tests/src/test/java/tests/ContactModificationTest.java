package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase{

    public List<ContactDataParametrs> before;
    public List<ContactDataParametrs> after;

    @BeforeMethod
    public void ensurePreconditions() {
//      проверка наличия контакта
        if(app.contact().list().size() == 0){
//      создание группы при её отсутствии
            app.group().exists(new GroupDataParametrs("test1", "test2", "test3"));
//      создание контакта при его отсутствии
            app.contact().create(new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954"), true);
        }
    }

    @Test
    public void testContactModification(){

//      Получаем количество контактов
        before = app.contact().list();

//      Индекс контакта
        int index = before.size() - 1;

        ContactDataParametrs contact = new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954");

        app.contact().modify(index, contact);

//      Получаем количество групп
        after = app.contact().list();

//      Проверяем количество контактов до и после
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);

        before.add(contact);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
