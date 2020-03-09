package addressbook_tests_parametrs;

import java.util.Objects;

public class ContactDataParametrs{
    public final String name;
    public final String patronymic;
    public final String lastName;
    public final String nickName;

    public final String title;
    public final String country;
    public final String phone;
    public final String mail;
    public final String bDay;
    public final String bMonth;
    public final String bYear;

    public ContactDataParametrs(String name, String patronymic, String lastName, String nickName, String title, String country, String phone, String mail, String bDay, String bMonth, String bYear) {
        this.name = name;
        this.patronymic = patronymic;
        this.lastName = lastName;
        this.nickName = nickName;
        this.title = title;
        this.country = country;
        this.phone = phone;
        this.mail = mail;
        this.bDay = bDay;
        this.bMonth = bMonth;
        this.bYear = bYear;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTitle() {
        return title;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getbDay() {
        return bDay;
    }

    public String getbMonth() {
        return bMonth;
    }

    public String getbYear() {
        return bYear;
    }

    @Override
    public String toString() {
        return "ContactDataParametrs{" +
                "name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDataParametrs that = (ContactDataParametrs) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(patronymic, that.patronymic) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, patronymic, lastName);
    }
}
