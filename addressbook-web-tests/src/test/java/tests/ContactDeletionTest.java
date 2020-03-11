package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase{

    public List<ContactDataParametrs> before;
    public List<ContactDataParametrs> after;
    @Test
    public void testContactDeletion(){
//        проверка наличия контакта
        if(app.contact().list().size() == 0){

//          создание группы при её отсутствии
            app.group().exists(new GroupDataParametrs("test1", "test2", "test3"));

//          создание контакта при его отсутствии
            app.contact().create(new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954"), true);
            System.out.println("Контакт создан");
        }

//      Получаем количество контактов
        before = app.contact().list();

        int index = before.size() - 1;

        app.contact().delete(index);

//      Получаем количество контактов
        after = app.contact().list();

//      Проверяем количество контактов до и после
        Assert.assertEquals(before.size(), after.size() + 1);

        before.remove(index);
        Assert.assertEquals(before,after);
    }



}
