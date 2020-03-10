package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase{

    public List<GroupDataParametrs> groupCountBefore;
    public List<GroupDataParametrs> groupCountAfter;

    @Test
    public void testGroupModification(){
//      переход на страницу с группами
        app.getNavigationHelper().gotoGroupPage();

//      проверка наличия группы
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDataParametrs("test1", "test2", "test3"));
        }

//      Получаем количество групп
//      groupCountBefore = app.getGroupHelper().groupCount();
        groupCountBefore = app.getGroupHelper().getGroupList();

//      выбор группы
        app.getGroupHelper().selectGroup(groupCountBefore.size() - 1);

//      нажатие на кнопку изменить
        app.getGroupHelper().submitGroupEdition();

//
        GroupDataParametrs group = new GroupDataParametrs(groupCountBefore.get(groupCountBefore.size()-1).getId(),"test1", "test2", "test3");

//      заполнение формы
        app.getGroupHelper().fillGroupForm(group);

//      подтверждение изменения
        app.getContactHelper().updateButton();

//      возврат на страницу с группами
        app.getNavigationHelper().returnToGroupPage();

//      Получаем количество групп
//      groupCountAfter = app.getGroupHelper().groupCount();
        groupCountAfter = app.getGroupHelper().getGroupList();

//      Проверяем количество групп до и после
        Assert.assertEquals(groupCountAfter.size(), groupCountBefore.size());

        groupCountBefore.remove(groupCountBefore.size() -1);
        groupCountBefore.add(group);

        Comparator <? super GroupDataParametrs> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
        groupCountBefore.sort(byId);
        groupCountAfter.sort(byId);
        Assert.assertEquals(groupCountBefore, groupCountAfter);
    }

}
