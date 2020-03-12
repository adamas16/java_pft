package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.Contacts;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    public Contacts before;
    public Contacts after;

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.group().exists(new GroupDataParametrs().withName("test1").withHeader("test2").withFooter("test3"));
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
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
