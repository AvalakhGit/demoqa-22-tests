import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/*
$("h1 div") - ищет div который является первым внутри какого-то h1
$("h1").$("div") - ищет первый div внутри первого h1. Если в первом h1 нет div - будет ошибка.
 */



public class GitHubSelenideSearch {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser="edge";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void searchSoftAssertions() {

        open("https://github.com/selenide/selenide/");

        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $(byText("Soft assertions")).shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();

        $$(".markdown-body h4").filterBy(text("Using JUnit5 extend test class:")).shouldHave(size(1));
        $$(".markdown-body h4").filterBy(text("Using JUnit5 extend test class:")).first().sibling(0).$("pre").shouldHave(text("SoftAssertsExtension.class"));

    }
    @AfterAll
    static void tearDown(){
        System.out.println("All done.");
    }
}
