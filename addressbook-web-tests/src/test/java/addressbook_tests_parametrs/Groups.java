package addressbook_tests_parametrs;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupDataParametrs> {
    private Set<GroupDataParametrs> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<>(groups.delegate);
    }
    public Groups() {
        this.delegate = new HashSet<>();
    }

    @Override
    protected Set<GroupDataParametrs> delegate() {
        return delegate;
    }

    public Groups withAdded (GroupDataParametrs group){
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;

    }
    public Groups without (GroupDataParametrs group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;

    }
}