package rumyantseva.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletion extends TestBase{

  @Test
  public void testGroupDeletion() throws Exception {
    app.gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }


}
