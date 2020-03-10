package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase{

    public List<GroupDataParametrs> groupCountBefore;
    public List<GroupDataParametrs> groupCountAfter;

    @BeforeMethod
    public void ensurePreconditions() {
        //      проверка наличия группы
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDataParametrs("test1", "test2", "test3"));
        }
    }

    @Test
    public void testGroupModification(){
//      переход на страницу с группами
        app.getNavigationHelper().gotoGroupPage();

//      Получаем количество групп
        groupCountBefore = app.getGroupHelper().getGroupList();

//      индекс группы
        int index = groupCountBefore.size() - 1;
        GroupDataParametrs group = new GroupDataParametrs(groupCountBefore.get(index).getId(),"test1", "test2", "test3");

        app.getGroupHelper().modifyGroup(index, group);

//      Получаем количество групп
        groupCountAfter = app.getGroupHelper().getGroupList();

//      Проверяем количество групп до и после
        Assert.assertEquals(groupCountAfter.size(), groupCountBefore.size());

        groupCountBefore.remove(index);
        groupCountBefore.add(group);

        Comparator <? super GroupDataParametrs> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
        groupCountBefore.sort(byId);
        groupCountAfter.sort(byId);
        Assert.assertEquals(groupCountBefore, groupCountAfter);
    }

}
