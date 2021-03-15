package rumyantseva.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rumyantseva.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class GroupDeletion extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup(new GroupData("EPyataya", "qwerty", "asdfgh"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    //before.remove (before.size() - 1);
    //for (int i = 0; i < after.size(); i++) {
    //  Assert.assertEquals(before, after);

    before.remove (before.size() - 1);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    }
  }
