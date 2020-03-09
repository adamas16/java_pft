package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase{
    public int groupCountBefore;
    public int groupCountAfter;

    @Test
    public void testGroupCreationTests()throws InterruptedException{
//      Переход на страницу групп
        app.getNavigationHelper().gotoGroupPage();

//      Получаем количество групп
        groupCountBefore = app.getGroupHelper().groupCount();

//      Нажатие на кнопку добавления группы
        app.getGroupHelper().initGroupCreation();

//      заполнение формы
        app.getGroupHelper().fillGroupForm(new GroupDataParametrs("test1", null, null));

//      Нажатие на кнопку создания группы
        app.getGroupHelper().submitGroupCreation();

//      Возврат на страницу группы
        app.getNavigationHelper().returnToGroupPage();

//      Получаем количество групп
        groupCountAfter = app.getGroupHelper().groupCount();

//      Проверяем количество групп до и после
        Assert.assertEquals(groupCountAfter,groupCountBefore + 1);

//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}