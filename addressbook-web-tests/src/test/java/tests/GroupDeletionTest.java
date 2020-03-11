package tests;

import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {

    public List<GroupDataParametrs> before;
    public List<GroupDataParametrs> after;

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        //если не сущ ни одной группы, то создать новую
        if (app.group().list().size() == 0) {
            app.group().create(new GroupDataParametrs().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {
        before = app.group().list();
        int index = before.size() - 1;
        app.group().delete(index);
        after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);

        Assert.assertEquals(before, after);

    }
}

//    @BeforeMethod
//    public void ensurePreconditions() {
////      проверка наличия группы
//        if(app.group().list().size() == 0){
//            app.group().create(new GroupDataParametrs().withName("test1"));
//        }
//    }
//
//    @Test
//    public void testGroupDeletion() {
//        app.goTo().groupPage();
//
////      переход на страницу с группами
//        before = app.group().list();
//        int index = before.size() - 1;
//
////      Получаем количество групп
//        app.group().delete(index);
//
////      Получаем количество групп
//        after = app.group().list();
//
////      Проверяем количество групп до и после
//        Assert.assertEquals(before.size(), after.size() + 1);
//
//        before.remove(index);
//        Assert.assertEquals(before, after);
//
//    }
//
//}
