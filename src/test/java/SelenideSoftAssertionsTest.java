import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertionsTest {
  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://github.com";
    Configuration.browserSize = "1920x1080";
    Configuration.holdBrowserOpen = true;
  }

  @Test
  void SoftAssertionsJUnit5Check() {
    open("/selenide/selenide");
    $("#wiki-tab").click();
    $(".wiki-rightbar").$$("li").last().$("button").click();
    $(".wiki-rightbar").$(byText("SoftAssertions")).click();
    $("#wiki-body").$$("h4").shouldHave(itemWithText("3. Using JUnit5 extend test class:"));

  }
}
