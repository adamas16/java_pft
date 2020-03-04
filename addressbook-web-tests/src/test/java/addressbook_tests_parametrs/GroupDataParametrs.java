package addressbook_tests_parametrs;

public class GroupDataParametrs {
    public final String name;
    public final String header;
    public final String footer;

    public GroupDataParametrs(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
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
}
