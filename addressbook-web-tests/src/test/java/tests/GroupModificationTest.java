package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification(){
//      переход на страницу с группами
        app.getNavigationHelper().gotoGroupPage();
//      проверка наличия группы
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDataParametrs("test1", "test2_edited", "test3_edited"));
        }
//      выбор группы
        app.getGroupHelper().selectGroup();
//      нажатие на кнопку изменить
        app.getGroupHelper().submitGroupEdition();
//      заполнение формы
        app.getGroupHelper().fillGroupForm(new GroupDataParametrs("test1", "test2_edited", "test3_edited"));
//      подтверждение изменения
        app.getContactHelper().updateButton();
//      возврат на страницу с группами
        app.getNavigationHelper().returnToGroupPage();
//      выход из аккаунта
        app.getSessionHelper().logout();
    }

}
