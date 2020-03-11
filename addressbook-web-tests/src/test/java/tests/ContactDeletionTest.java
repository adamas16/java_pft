package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactDeletionTest extends TestBase {

    public Set<ContactDataParametrs> before;
    public Set<ContactDataParametrs> after;

    @BeforeMethod
    public void ensurePreconditions() {

        if (app.contact().list().size() == 0) {

            app.group().exists(new GroupDataParametrs().withName("test1").withHeader("test2").withFooter("test3"));

            app.contact().create(new ContactDataParametrs().withName("Dmitriy").withLastName("Romanov").withNickName("arrnel").withCountry("Russia").withPhone("+7(658)4853568"), true);
        }
    }

    @Test
    public void testContactDeletion() throws Exception{
        before = app.contact().all();

        Set<ContactDataParametrs> before = app.contact().all();
        ContactDataParametrs deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactDataParametrs> after = app.contact().all();
        Assert.assertEquals(after.size(),before.size()-1);
        before.remove(deletedContact);
        Assert.assertEquals(before, after);


    }

}
