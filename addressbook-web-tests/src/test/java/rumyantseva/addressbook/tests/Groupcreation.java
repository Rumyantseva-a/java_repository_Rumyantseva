package rumyantseva.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import rumyantseva.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class Groupcreation extends TestBase{

  @Test
  public void testGroupcreation() throws Exception {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData("Newlambda", "Meow", "Yau");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    //старый способ - с помощью цикла
    //int max = 0;
    //for (GroupData g : after) {
    //  if (g.getId() > max) {
    //    max = g.getId();
    //  }
    //}


    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
