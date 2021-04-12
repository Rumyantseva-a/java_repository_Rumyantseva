package rumyantseva.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class ContactsInGroupsTest extends TestBase{

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


  @Test
  public void testContactInGroup() throws Exception {

    Contacts before = app.db().contacts();
    Groups groups = app.db().groups();
    ContactData addedContactInGroup = before.iterator().next();
    GroupData selectedGroup = groups.iterator().next();
    Groups groupsOfContact = new Groups();

    for (ContactData selContact : before)
    {
      System.out.println(selContact.getId());
      int st = 0;

      for (GroupData selGroup : groups)
      {
        if (!selContact.getGroups().contains(selGroup))
        {
          System.out.println("   -" + selGroup.getId());
          addedContactInGroup = selContact;
          selectedGroup = selGroup;
          groupsOfContact = addedContactInGroup.getGroups();
          st = 1;
          break;
        }

      }
      if (st > 0) break;
    }

    //если контакт уже в выбранной группе - предварительно удалить его из нее
    if (groupsOfContact.contains(selectedGroup)) {
      app.goTo().homePage();
      app.contact().deleteFromGroup(addedContactInGroup, selectedGroup);
      //before = app.db().contacts();
    }

    app.goTo().homePage();
    app.contact().addToGroup(addedContactInGroup, selectedGroup);
    //assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();

    Groups afterContactGroups = after.getContactById(addedContactInGroup.getId()).getGroups();
    Groups beforeGroupsOfContact = groupsOfContact;
    beforeGroupsOfContact.add(selectedGroup);

    //assertThat(after, equalTo(before.without(addedContactInGroup).withAdded(addedContactInGroup.withGroups(selectedGroup))));
    assertThat(afterContactGroups , equalTo(beforeGroupsOfContact));
    verifyContactListInUI();
  }


}
