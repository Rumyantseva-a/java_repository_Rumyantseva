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
    Groups groupsOfContact = addedContactInGroup.getGroups();

    //если контакт уже в выбранной группе - предварительно удалить его из нее
    if (groupsOfContact.contains(selectedGroup)) {
      app.goTo().homePage();
      app.contact().deleteFromGroup(addedContactInGroup, selectedGroup);
      //before = app.db().contacts();
    }

    app.goTo().homePage();
    app.contact().deleteFromGroup(addedContactInGroup, selectedGroup);
    //assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(addedContactInGroup).withAdded(addedContactInGroup.withGroups(selectedGroup))));
    verifyContactListInUI();
  }


}
