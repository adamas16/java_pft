package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTest extends TestBase{
    public List<GroupDataParametrs> before;
    public List<GroupDataParametrs> after;

    @Test
    public void testGroupCreationTests(){
//      Переход на страницу групп
        app.goTo().groupPage();

//      Получаем количество групп
        before = app.group().list();
//      groupCountBefore = app.getGroupHelper().groupCount();
        GroupDataParametrs group = new GroupDataParametrs().withName("test1");

        app.group().createGroup(group);

//      Получаем количество групп
        after = app.group().list();
//      groupCountAfter = app.getGroupHelper().groupCount();

//      Проверяем количество групп до и после
        Assert.assertEquals(before.size(), after.size() - 1);

        before.add(group);
        int max = 0;
        for(GroupDataParametrs c : after){
            if(c.getId() > max){
                max = c.getId();
            }
        }

        group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        Comparator <? super GroupDataParametrs> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
}
}