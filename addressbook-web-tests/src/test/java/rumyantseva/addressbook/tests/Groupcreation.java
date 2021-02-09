package rumyantseva.addressbook.tests;

import org.testng.annotations.*;
import rumyantseva.addressbook.model.GroupData;

public class Groupcreation extends TestBase{

  @Test
  public void testGroupcreation() throws Exception {
    app.gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("Pyataya", "qwerty", "asdfgh"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }


}
