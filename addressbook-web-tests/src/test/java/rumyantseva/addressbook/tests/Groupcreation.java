package rumyantseva.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import rumyantseva.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class Groupcreation extends TestBase{

  @Test
  public void testGroupcreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("New", "Meow", "Yau");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = 0;
    for (GroupData g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}
