package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.Contacts;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase{

    public Contacts before;
    public Contacts after;

    @Test
    public void testContactCreation(){
        app.group().exists(new GroupDataParametrs().withName("test1").withHeader("test2").withFooter("test3"));
        before = app.contact().all();
        ContactDataParametrs contact = new ContactDataParametrs().withName("Dmitriy").withLastName("Romanov").withNickName("arrnel").withCountry("Russia").withPhone("+7(658)4853568");
        app.contact().create(contact,true);
        after = app.contact().all();
        assertEquals(after.size(),before.size() + 1);
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

}
