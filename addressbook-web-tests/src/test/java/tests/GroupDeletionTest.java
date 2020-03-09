package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{

    public int groupCountBefore;
    public int groupCountAfter;

    @Test
    public void testGroupDeletion()  throws Exception {
//      переход на страницу с группами
        app.getNavigationHelper().gotoGroupPage();

//      проверка наличия группы
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDataParametrs("test1", "test2_edited", "test3_edited"));
        }

//      Получаем количество групп
        groupCountBefore = app.getGroupHelper().groupCount();

//      выбор группы
        app.getGroupHelper().selectGroup();

//      подтверждение удаления
        app.getGroupHelper().submitGroupDeletion();

//      возврат на страницу с группами
        app.getNavigationHelper().returnToGroupPage();

//      Получаем количество групп
        groupCountAfter = app.getGroupHelper().groupCount();

//      Проверяем количество групп до и после
        Assert.assertEquals(groupCountAfter, groupCountBefore - 1);

//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}
