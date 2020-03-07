package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion()  throws Exception {
//      переход на страницу с группами
        app.getNavigationHelper().gotoGroupPage();
//      проверка наличия группы
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDataParametrs("test1", "test2_edited", "test3_edited"));
        }
//      выбор группы
        app.getGroupHelper().selectGroup();
//      подтверждение удаления
        app.getGroupHelper().submitGroupDeletion();
//      возврат на страницу с группами
        app.getNavigationHelper().returnToGroupPage();
//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}
