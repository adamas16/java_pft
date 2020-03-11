package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactModificationTest extends TestBase {

    public Set<ContactDataParametrs> before;
    public Set<ContactDataParametrs> after;

    @BeforeMethod
    public void ensurePreconditions() {
//      проверка наличия контакта
        if (app.contact().list().size() == 0) {
//      создание группы при её отсутствии
            app.group().exists(new GroupDataParametrs().withName("test1").withHeader("test2").withFooter("test3"));
//      создание контакта при его отсутствии
            app.contact().create(new ContactDataParametrs().withName("Dmitriy").withLastName("Romanov").withNickName("arrnel").withCountry("Russia").withPhone("+7(658)4853568"), true);
        }
    }

    @Test
    public void testContactModification() {

        before = app.contact().all();

        ContactDataParametrs modifiedContact = before.iterator().next();

        ContactDataParametrs contact = new ContactDataParametrs().withId(modifiedContact.getId()).withName("Dmitriy").withLastName("Romanov").withNickName("arrnel").withCountry("Russia").withPhone("+7(658)4853568");


        app.contact().modify(contact);


        after = app.contact().all();

        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);

        Assert.assertEquals(before, after);
    }
}
