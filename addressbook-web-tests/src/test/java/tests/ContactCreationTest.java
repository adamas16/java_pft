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

        ContactDataParametrs contact = new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954");

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
        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        contact.setId(max);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        Comparator<? super ContactDataParametrs> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
