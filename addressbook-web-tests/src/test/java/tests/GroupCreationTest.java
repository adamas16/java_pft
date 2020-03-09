package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTest extends TestBase{
    public List<GroupDataParametrs> groupCountBefore;
    public List<GroupDataParametrs> groupCountAfter;

    @Test
    public void testGroupCreationTests()throws InterruptedException{
//      Переход на страницу групп
        app.getNavigationHelper().gotoGroupPage();

//      Получаем количество групп
        groupCountBefore = app.getGroupHelper().getGroupList();
//      groupCountBefore = app.getGroupHelper().groupCount();

//      Нажатие на кнопку добавления группы
        app.getGroupHelper().initGroupCreation();

        GroupDataParametrs group = new GroupDataParametrs("test1", "test2", "test3");
//      заполнение формы
        app.getGroupHelper().fillGroupForm(group);

//      Нажатие на кнопку создания группы
        app.getGroupHelper().submitGroupCreation();

//      Возврат на страницу группы
        app.getNavigationHelper().returnToGroupPage();

//      Получаем количество групп
        groupCountAfter = app.getGroupHelper().getGroupList();
//      groupCountAfter = app.getGroupHelper().groupCount();

//      Проверяем количество групп до и после
        Assert.assertEquals(groupCountBefore.size(),groupCountAfter.size() - 1);

        groupCountBefore.add(group);
        int max = 0;
        for(GroupDataParametrs c : groupCountAfter){
            if(c.getId()>max){
                max = c.getId();
            }
        }
        group.setId(max);
        Assert.assertEquals(new HashSet<Object>(groupCountBefore), new HashSet<Object>(groupCountAfter));

//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}