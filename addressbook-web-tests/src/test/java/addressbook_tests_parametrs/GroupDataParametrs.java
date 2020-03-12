package addressbook_tests_parametrs;

import java.util.Objects;

public class GroupDataParametrs {

    public int id = Integer.MAX_VALUE;;
    public String name;
    public String header;
    public String footer;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public GroupDataParametrs withId(int id){
        this.id = id;
        return this;
    }


    public GroupDataParametrs withName(String name) {
        this.name = name;
        return this;
    }

    public GroupDataParametrs withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupDataParametrs withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public String toString() {
        return "GroupDataParametrs{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDataParametrs that = (GroupDataParametrs) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}
