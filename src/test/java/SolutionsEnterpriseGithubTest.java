import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SolutionsEnterpriseGithubTest {

    @Test
    void hoverForSolutions() {
        // На главной странице GitHub выберите меню Solutions -> Enterprise с помощью команды hover для Solutions.
        open("https://github.com/");
        $("div.d-flex").$(byText("Solutions")).hover();
        $("#solutions-for-heading").sibling(0).$(byText("Enterprise")).click();

        // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        $("h1.h1-mktg.mb-3.color-fg-default").shouldHave(text("Build like the best"));
    }
}
