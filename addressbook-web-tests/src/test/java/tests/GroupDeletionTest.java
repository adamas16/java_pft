package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase{

    public List<GroupDataParametrs> groupCountBefore;
    public List<GroupDataParametrs> groupCountAfter;

    @Test
    public void testGroupDeletion()  throws Exception {
//      переход на страницу с группами
        app.getNavigationHelper().gotoGroupPage();

//      проверка наличия группы
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDataParametrs("test1", "test2_edited", "test3_edited"));
        }

//      Получаем количество групп
//      groupCountBefore = app.getGroupHelper().groupCount();
        groupCountBefore = app.getGroupHelper().getGroupList();

//      выбор группы
        app.getGroupHelper().selectGroup(groupCountBefore.size() - 1);

//      подтверждение удаления
        app.getGroupHelper().submitGroupDeletion();

//      возврат на страницу с группами
        app.getNavigationHelper().returnToGroupPage();

//      Получаем количество групп
//      groupCountAfter = app.getGroupHelper().groupCount();
        groupCountAfter = app.getGroupHelper().getGroupList();

//      Проверяем количество групп до и после
//      Assert.assertEquals(groupCountAfter, groupCountBefore - 1);
        Assert.assertEquals(groupCountAfter.size(),groupCountBefore.size() -1);

        groupCountBefore.remove(groupCountBefore.size() - 1);
        Assert.assertEquals(groupCountBefore, groupCountAfter);

//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}
