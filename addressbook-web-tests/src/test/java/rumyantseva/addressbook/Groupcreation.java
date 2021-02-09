package rumyantseva.addressbook;

import org.testng.annotations.*;

public class Groupcreation extends TestBase{

  @Test
  public void testGroupcreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Pyataya", "qwerty", "asdfgh"));
    submitGroupCreation();
    returnToGroupPage();
  }


}
