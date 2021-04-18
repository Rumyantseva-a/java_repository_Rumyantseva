package rumyantseva.rest.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;

public class TestBase {


  public boolean isIssueNotFixed(int issueId) throws IOException {
//    Set<Issue> issues = getIssues();
    Issue issue = getIssueId(issueId);
    String status = issue.getState_name();


    if (status.equals("Closed"))
      return false;
    else
      return true;
  }



  private Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues.json"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }

  private Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
  }

  private Issue getIssueId(int id) throws IOException {
    String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues/"+id+".json"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    Set<Issue> ret = new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());

    return ret.iterator().next();
  }

  //issues/{issue_id}.


  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueNotFixed(issueId)) {
      System.out.println("Ignored because of issue " + issueId);
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}
