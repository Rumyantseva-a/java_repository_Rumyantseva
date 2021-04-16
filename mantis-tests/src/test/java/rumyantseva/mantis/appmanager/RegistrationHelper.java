package rumyantseva.mantis.appmanager;

import org.openqa.selenium.By;
//import rumyantseva.mantis.model.UserData;

public class RegistrationHelper extends HelperBase {


  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    type(By.name("username"), username);
    type(By.name("email"), email);
    click(By.cssSelector("input[value='Зарегистрироваться']"));

  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.xpath("//*[.='Изменить пользователя'] "));


  }

  public void adminLogin(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.cssSelector("input[value='Вход']"));
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Вход']"));
  }

  /*public void changeUsersPassword (UserData user) {
    goToManageOverviewPage();
    goToManageUserPage();
    selectUser(user);
    changePassword();
  }

   */


  public void goToManageOverviewPage() {
    click(By.xpath("//a[@href='/mantisbt-2.25.0/manage_overview_page.php']"));
    // from contacthelper: click(By.xpath("//a[@href='edit.php?id="+ id +"']"));
  }

  public void goToManageUserPage() {
    click(By.xpath("//a[@href='/mantisbt-2.25.0/manage_user_page.php']"));
  }

  /*public void selectUser(UserData user) {
    click(By.xpath("//*[.='" + user + "'] "));
  }


   */
  public void changePassword() {
    click(By.cssSelector("input[value='Сбросить пароль']"));
  }

}
