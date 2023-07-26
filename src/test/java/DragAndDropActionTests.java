import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropActionTests {

    @BeforeEach
    void beforeEach() {
        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    void dragAndDropAction() {

        // Перенесите прямоугольник А на место В
        actions().clickAndHold($("#column-a"))
                .moveToElement($("#column-b")).release().perform();

        // Проверьте, что прямоугольники действительно поменялись
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void dragAndDropActionSelenide() {
        // команда $(element).dragAndDrop(to($(element)))
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-b").shouldHave(text("A"));
    }
}
