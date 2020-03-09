package tests;

import addressbook_tests_parametrs.ContactDataParametrs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

    public int groupCountBefore;
    public int groupCountAfter;

    @Test
    public void testContactCreation() throws Exception{
//      Получаем количество контактов
        groupCountBefore = app.getGroupHelper().groupCount();

//      добавляем контакт
        app.getContactHelper().initContactCreation();

//      заполнение формы
        app.getContactHelper().fillContactForm(new ContactDataParametrs("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954"), true);

//      нажать на подтверждение создание контакта
        app.getContactHelper().submitContactCreation();

//      возврат на главную страницу
        app.getNavigationHelper().gotoMainPage();

//      Получаем количество групп
        groupCountAfter = app.getGroupHelper().groupCount();

//      Проверяем количество контактов до и после
        Assert.assertEquals(groupCountAfter, groupCountBefore + 1);

//      выход из аккаунта
        app.getSessionHelper().logout();
    }



}
