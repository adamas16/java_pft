package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase{

    public List<GroupDataParametrs> before;
    public List<GroupDataParametrs> after;

    @BeforeMethod
    public void ensurePreconditions() {
//      проверка наличия группы
        if(!app.group().isThereAGroup()){
            app.group().create(new GroupDataParametrs().withName("test1"));
        }
    }

    @Test
    public void testGroupModification(){
//      переход на страницу с группами
        app.goTo().groupPage();

//      Получаем количество групп
        before = app.group().list();

//      индекс группы
        int index = before.size() - 1;
        GroupDataParametrs group = new GroupDataParametrs()
                .withId(before.get(index).getId()).withName("test1").withHeader("test2").withFooter("test3");

        app.group().modifyGroup(index, group);

//      Получаем количество групп
        after = app.group().list();

//      Проверяем количество групп до и после
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);

        Comparator <? super GroupDataParametrs> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
