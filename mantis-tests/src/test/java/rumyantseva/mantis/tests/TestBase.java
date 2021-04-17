package rumyantseva.mantis.tests;

//import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import rumyantseva.mantis.appmanager.ApplicationManager;
import biz.futureware.mantis.rpc.soap.client.*;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;

public class TestBase {

Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " +m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " +m.getName());
  }

  public boolean isIssueNotFixed(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = new MantisConnectLocator()
            .getMantisConnectPort(new URL(app.getProperty("soap.baseUrl")));
    IssueData issueData = mc.mc_issue_get(app.getProperty("soap.adminLogin"), app.getProperty("soap.adminPassword"), BigInteger.valueOf(issueId));
    String res = issueData.getResolution().getName();

    if (res.equals("fixed"))
      return false;
      else
        return true;
  }


  public void skipIfNotFixed(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    if (isIssueNotFixed(issueId)) {
      System.out.println("Ignored because of issue " + issueId);
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }


}
