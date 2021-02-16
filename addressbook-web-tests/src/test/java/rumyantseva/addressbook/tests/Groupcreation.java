package rumyantseva.addressbook.tests;

import org.testng.annotations.*;
import rumyantseva.addressbook.model.GroupData;

public class Groupcreation extends TestBase{

  @Test
  public void testGroupcreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("New", "Meow", "Yau"));
  }


}
