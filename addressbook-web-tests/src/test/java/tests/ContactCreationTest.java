package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase{

    public List<ContactDataParametrs> before;
    public List<ContactDataParametrs> after;

    @Test
    public void testContactCreation(){
//      Получаем количество контактов
        before = app.contact().list();

        ContactDataParametrs contact = new ContactDataParametrs().withName("Dmitriy").withLastName("Romanov").withNickName( "arrnel").withCountry("Russia").withPhone("+7(658)4853568");

        app.contact().createContact(contact);

//      Получаем количество групп
        after = app.contact().list();

//      Проверяем количество контактов до и после
        Assert.assertEquals(before.size(), after.size() - 1);

        before.add(contact);
        int max = 0;
        for(ContactDataParametrs c : after){
            if(c.getId()>max){
                max = c.getId();
            }
        }
        contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        contact.withId(max);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        Comparator<? super ContactDataParametrs> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
