package qaunit12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static qaunit12.TestData.*;

public class SelenideTest extends TestBase {


    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(PAGE_URL);

        $(".search-input").click();
        $("#query-builder-test").sendKeys(REPO);
        $("#query-builder-test").pressEnter();

        $(linkText(REPO)).click();
        $("#issues-tab").click();
        $(withText(ISSUE_NUMBER)).should(Condition.exist);
    }

}