package rumyantseva.github.tests;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("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");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("Rumyantseva-a", "java_repository_Rumyantseva")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());

    }
  }

}
