package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreationTests(){
//      Переход на страницу групп
        app.getNavigationHelper().gotoGroupPage();
//      Нажатие на кнопку добавления группы
        app.getGroupHelper().initGroupCreation();
//      заполнение формы
        app.getGroupHelper().fillGroupForm(new GroupDataParametrs("test1", null, null));
//      Нажатие на кнопку создания группы
        app.getGroupHelper().submitGroupCreation();
//      Возврат на страницу группы
        app.getNavigationHelper().returnToGroupPage();
//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}