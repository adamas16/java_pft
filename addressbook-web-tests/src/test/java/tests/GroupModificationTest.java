package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import addressbook_tests_parametrs.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase{

    public Groups before;
    public Groups after;

    @BeforeMethod
    public void ensurePreconditions() {
//      проверка наличия группы
        if(!app.group().isThereAGroup()){
            app.group().create(new GroupDataParametrs().withName("test1"));
        }
    }

    @Test
    public void testGroupModification(){
//        app.goTo().groupPage();
        before = app.group().all();
        GroupDataParametrs modifiedGroup = before.iterator().next();
        GroupDataParametrs group = new GroupDataParametrs()
                .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modifyGroup(group);
        assertThat(app.group().count(), equalTo(before.size()));
        after = app.group().all();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}
