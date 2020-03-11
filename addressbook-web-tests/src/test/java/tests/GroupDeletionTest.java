package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase{

    public List<GroupDataParametrs> before;
    public List<GroupDataParametrs> after;

    @BeforeMethod
    public void ensurePreconditions() {
//      проверка наличия группы
        if(app.group().list().size() == 0){
            app.group().create(new GroupDataParametrs("test1", "test2", "test3"));
        }
    }

    @Test
    public void testGroupDeletion(){
//      переход на страницу с группами
        app.goTo().gotoGroupPage();

        int index = before.size() - 1;

//      Получаем количество групп
//      groupCountBefore = app.getGroupHelper().groupCount();
        before = app.group().list();
        app.group().delete(index);

//      Получаем количество групп
//      groupCountAfter = app.getGroupHelper().groupCount();
        after = app.group().list();

//      Проверяем количество групп до и после
//      Assert.assertEquals(groupCountAfter, groupCountBefore - 1);
        Assert.assertEquals(before.size(), after.size() + 1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }

}
