package rumyantseva.addressbook.tests;

import org.testng.annotations.Test;
import rumyantseva.addressbook.model.GroupData;

public class GroupModification extends TestBase {


  @Test
  public void testGroupModification() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("3ModPyataya1", "rty", "rty"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}

