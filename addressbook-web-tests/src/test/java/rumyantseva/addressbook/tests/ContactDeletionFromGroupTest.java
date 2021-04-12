package rumyantseva.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.Assert;
import org.testng.annotations.*;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.Contacts;
import rumyantseva.addressbook.model.GroupData;
import rumyantseva.addressbook.model.Groups;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactDeletionFromGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions0() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @BeforeMethod
  public void ensurePreconditions1() {
    if (app.db().contacts().size() == 0) {
      app.goTo().addNewPage();
      app.contact().create(new ContactData().withFirstName("Fhygbj").withLastName("Atggfrg"), true);
    }
  }

  /*@BeforeMethod
  public void ensurePreconditions2() {
    if (----) {
      Contacts before = app.db().contacts();
      Groups groups = app.db().groups();
      ContactData addedContactInGroup = before.iterator().next();
      GroupData selectedGroup = groups.iterator().next();
      app.goTo().homePage();
      app.contact().addToGroup(addedContactInGroup, selectedGroup);
    }
  }*/


  @Test
  public void testContactDeletionFromGroup() throws Exception {

    Contacts before = app.db().contacts();
    ContactData deletedContactFromGroup = before.iterator().next();
    Groups groups = deletedContactFromGroup.getGroups();
    GroupData selectedGroup = new GroupData();
    Groups groupsOfContact = new Groups();

    for (ContactData selContact : before)
    {
      System.out.println(selContact.getId());
      int st = 0;

      for (GroupData selGroup : selContact.getGroups())
      {
        if (selContact.getGroups().contains(selGroup))
        {
          System.out.println("   +" + selGroup.getId());
          deletedContactFromGroup = selContact;
          selectedGroup = selGroup;
          groupsOfContact = deletedContactFromGroup.getGroups();
          st = 1;
          break;
        }

      }
      if (st > 0) break;
    }

    if (!groupsOfContact.contains(selectedGroup)) {
      //Groups groupsAll = app.db().groups();
      //selectedGroup = groupsAll.iterator().next();
      app.goTo().homePage();
      app.contact().addToGroup(deletedContactFromGroup, selectedGroup);
     // before = app.db().contacts();
     // deletedContactFromGroup = deletedContactFromGroup.withGroups(selectedGroup);
    }


    app.goTo().homePage();
    app.contact().deleteFromGroup(deletedContactFromGroup, selectedGroup);
    Contacts after = app.db().contacts();

    Groups afterContactGroups = after.getContactById(deletedContactFromGroup.getId()).getGroups();
    Groups beforeGroupsOfContact = groupsOfContact;
    beforeGroupsOfContact.remove(selectedGroup);

    assertThat(afterContactGroups , equalTo(beforeGroupsOfContact));

    //assertThat(after, equalTo(before.without(deletedContactFromGroup).withAdded(deletedContactFromGroup.withoutGroups(selectedGroup))));
    verifyContactListInUI();
  }

}
