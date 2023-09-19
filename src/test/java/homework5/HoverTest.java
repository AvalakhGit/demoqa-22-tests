package homework5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HoverTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser="edge";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void useHoverOver() {
        Configuration.browserSize = "2040x1200";
        open("https://github.com/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(byAttribute("aria-labelledby","solutions-for-heading")).$(byText("Enterprise")).click();
        $(".font-mktg").shouldHave(text("Build like the best"));
    }
}
