package addressbook_tests_parametrs;

import com.google.common.collect.ForwardingSet;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactDataParametrs> {
    private Set<ContactDataParametrs> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactDataParametrs>(contacts.delegate);
    }
    public Contacts() {
        this.delegate = new HashSet<ContactDataParametrs>();
    }

    @Override
    protected Set<ContactDataParametrs> delegate() {
        return delegate;
    }


    public Contacts withAdded (ContactDataParametrs contact){
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;

    }
    public Contacts without (ContactDataParametrs contact){
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}
