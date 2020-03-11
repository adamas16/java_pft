package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import addressbook_tests_parametrs.GroupDataParametrs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase{

    public List<ContactDataParametrs> before;
    public List<ContactDataParametrs> after;

    @BeforeMethod
    public void ensurePreconditions() {
//      проверка наличия контакта
        if(app.contact().list().size() == 0){
//      создание группы при её отсутствии
            app.group().exists(new GroupDataParametrs().withName("test1").withHeader("test2").withFooter("test3"));
//      создание контакта при его отсутствии
            app.contact().create(new ContactDataParametrs().withName("Dmitriy").withLastName("Romanov").withNickName("arrnel").withCountry("Russia").withPhone("+7(658)4853568"), true);
        }
    }

    @Test
    public void testContactModification(){
//      Получаем количество контактов
        before = app.contact().list();

//      Индекс контакта
        int index = before.size() - 1;

        ContactDataParametrs contact = new ContactDataParametrs().withId(before.get(index).getId()).withName("Dmitriy").withLastName("Romanov").withNickName( "arrnel").withCountry("Russia").withPhone("+7(658)4853568");

//      Модифицируем контакт
        app.contact().modify(index, contact);

//      Получаем количество контактов
        after = app.contact().list();

//      Сравнение
        Assert.assertEquals(after.size(), before.size());


        before.remove(index);
        before.add(contact);

//      2 потока. Сортировка и сравнение
        Comparator<? super ContactDataParametrs> byId=(g1, g2)-> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
