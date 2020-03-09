package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

    public int groupCountBefore;
    public int groupCountAfter;

    @Test
    public void testGroupModification() throws Exception{
//      переход на страницу с группами
        app.getNavigationHelper().gotoGroupPage();

//      проверка наличия группы
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDataParametrs("test1", "test2_edited", "test3_edited"));
        }

//      Получаем количество групп
        groupCountBefore = app.getGroupHelper().groupCount();

//      выбор группы
        app.getGroupHelper().selectGroup(groupCountBefore - 1);

//      нажатие на кнопку изменить
        app.getGroupHelper().submitGroupEdition();

//      заполнение формы
        app.getGroupHelper().fillGroupForm(new GroupDataParametrs("test1", "test2_edited", "test3_edited"));

//      подтверждение изменения
        app.getContactHelper().updateButton();

//      возврат на страницу с группами
        app.getNavigationHelper().returnToGroupPage();

//      Получаем количество групп
        groupCountAfter = app.getGroupHelper().groupCount();

//      Проверяем количество групп до и после
        Assert.assertEquals(groupCountAfter, groupCountBefore);

//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}
