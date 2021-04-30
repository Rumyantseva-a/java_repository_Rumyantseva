package rumyantseva.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import rumyantseva.mantis.model.MailMessage;
import rumyantseva.mantis.model.UserData;
import rumyantseva.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;

public class PasswordChangeTests extends TestBase{

 // @BeforeMethod
  public void startMailServer () {
    app.mail().start();
  }

  @Test
  public void testPasswordChange() throws IOException, MessagingException, InterruptedException {
    //HttpSession session = app.newSession();
    //assertTrue(session.login("administrator","root"));

    Users users = app.db().users();
    UserData userForChangePassword = users.iterator().next();
    //String user = "userforchangepassword";
    String password = "newpassword";
    //String email = "userforchangepassword@localhost.localdomain";
    String email = userForChangePassword.getEmail();

    app.registration().adminLogin("administrator","root");
    app.registration().changeUsersPassword(userForChangePassword);

    //List<MailMessage> mailMessages = app.mail().waitForMail(1, 1000);
    sleep (20000);
    List<MailMessage> mailMessages = app.james().waitForMail(userForChangePassword.getUsername(), "password", 120000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(userForChangePassword.getUsername(), password));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);

  }

 // @AfterMethod(alwaysRun = true)
  public void stopMailServer () {
    app.mail().stop();
  }


}



