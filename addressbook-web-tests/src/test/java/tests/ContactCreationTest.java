package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactCreationTest extends TestBase{

    public Set<ContactDataParametrs> before;
    public Set<ContactDataParametrs> after;

    @Test
    public void testContactCreation(){
        app.group().exists(new GroupDataParametrs().withName("test1").withHeader("test2").withFooter("test3"));

        Set<ContactDataParametrs> before = app.contact().all();
        ContactDataParametrs contact = new ContactDataParametrs().withName("Dmitriy").withLastName("Romanov").withNickName("arrnel").withCountry("Russia").withPhone("+7(658)4853568");
        app.contact().create(contact,true);
        after = app.contact().all();
        Assert.assertEquals(after.size(),before.size() + 1);
        // contact.withId(after.stream().max( (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before,after);
    }

}
