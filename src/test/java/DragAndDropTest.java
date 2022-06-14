import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;


public class DragAndDropTest {
  @BeforeAll
  static void beforeAll() {
    open("https://the-internet.herokuapp.com/drag_and_drop");
    Configuration.browserSize = "1920x1080";
    Configuration.holdBrowserOpen = true;
  }


  @DisplayName("Drag and Drop Selenide test")
  @Test
  void dragAndDrop() {
    $("#column-a").dragAndDropTo("#column-b");
    $("#column-a").shouldHave(Condition.text("B"));
    $("#column-b").shouldHave(Condition.text("A"));
  }

  @Disabled
  @DisplayName("Drag and Drop Selenide.actions test") // тест не работает
  @Test
  void dragAndDropActions() {
    SelenideElement box = $("#column-a");
    actions().dragAndDropBy(box, 200, 300).perform();
    $("#column-a").shouldHave(Condition.text("B"));
    $("#column-b").shouldHave(Condition.text("A"));
  }


}
