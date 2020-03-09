package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase{

    public int groupCountBefore;
    public int groupCountAfter;

    @Test
    public void testGroupModification() throws Exception{
//      переход на страницу с группами
        app.getNavigationHelper().gotoGroupPage();

//      проверка наличия группы
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDataParametrs("test1", "test2", "test3"));
        }

//      Получаем количество групп
//      groupCountBefore = app.getGroupHelper().groupCount();
        List<GroupDataParametrs> groupCountBefore = app.getGroupHelper().getGroupList();

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
        List<GroupDataParametrs> groupCountAfter = app.getGroupHelper().getGroupList();

//      Проверяем количество групп до и после
        Assert.assertEquals(groupCountAfter.size(), groupCountBefore.size());

        groupCountBefore.remove(groupCountBefore.size() -1);
        groupCountBefore.add(group);
        Assert.assertEquals(new HashSet<Object>(groupCountBefore), new HashSet<Object>(groupCountAfter));

//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}
