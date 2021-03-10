package rumyantseva.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rumyantseva.addressbook.model.GroupData;
import java.util.HashSet;
import java.util.List;

public class GroupModification extends TestBase {


  @Test
  public void testGroupModification() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup(new GroupData("EPyataya", "qwerty", "asdfgh"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "1odPuataya1", "rty", "rty");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove (before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}

