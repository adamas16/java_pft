package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import addressbook_tests_parametrs.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTest extends TestBase {

    public Groups before;
    public Groups after;

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupDataParametrs().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {
        before = app.group().all();
        GroupDataParametrs deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size()-1));
        after = app.group().all();
        assertThat(after, equalTo(before.without(deletedGroup)));
    }
}

