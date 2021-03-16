package rumyantseva.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import rumyantseva.addressbook.model.GroupData;
import java.util.Set;

public class Groupcreation extends TestBase{

  @Test
  public void testGroupcreation() throws Exception {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);


    //старый способ - с помощью цикла
    //int max = 0;
    //for (GroupData g : after) {
    //  if (g.getId() > max) {
    //    max = g.getId();
    //  }
    //}


    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
  }


}
