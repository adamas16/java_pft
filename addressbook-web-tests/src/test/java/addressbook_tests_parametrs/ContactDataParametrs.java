package addressbook_tests_parametrs;

import java.util.Objects;

public class ContactDataParametrs{
    public int id;
    public String name;
    public String lastName;
    public String nickName;
    public String country;
    public String phone;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public ContactDataParametrs withId(int id) {
        this.id = id;
        return this;
    }

    public ContactDataParametrs withName(String name) {
        this.name = name;
        return this;
    }

    public ContactDataParametrs withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactDataParametrs withNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public ContactDataParametrs withCountry(String country) {
        this.country = country;
        return this;
    }

    public ContactDataParametrs withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return "ContactDataParametrs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDataParametrs that = (ContactDataParametrs) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName);
    }
}
