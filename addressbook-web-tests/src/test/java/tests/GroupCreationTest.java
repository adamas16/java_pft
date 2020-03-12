package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import addressbook_tests_parametrs.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupCreationTest extends TestBase{
    public Groups before;
    public Groups after;

    @Test
    public void testGroupCreationTests(){
        app.goTo().groupPage();
        before = app.group().all();
        GroupDataParametrs group = new GroupDataParametrs().withName("test1");
        app.group().createGroup(group);
        after = app.group().all();
        assertThat(after.size(), equalTo(before.size()+1));
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }
}