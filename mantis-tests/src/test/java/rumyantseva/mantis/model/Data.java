package rumyantseva.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Data extends ForwardingSet<GroupData> {

  private Set<GroupData> delegate;

  public Data(Data groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  public Data() {
    this.delegate = new HashSet<GroupData>();
  }

  public Data(Collection<GroupData> groups) {
    this.delegate = new HashSet<GroupData>(groups);
  }


  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }

  public Data withAdded (GroupData group) {
    Data groups = new Data(this);
    groups.add(group);
    return groups;
  }

  public Data without (GroupData group) {
    Data groups = new Data(this);
    groups.remove(group);
    return groups;
  }
}
