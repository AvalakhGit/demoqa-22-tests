package qaunit12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {
    TestData testData = new TestData();

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(testData.PAGE_URL);

        $(".search-input").click();
        $("#query-builder-test").sendKeys(testData.REPO);
        $("#query-builder-test").pressEnter();

        $(linkText(testData.REPO)).click();
        $("#issues-tab").click();
        $(withText(testData.ISSUE_NUMBER)).should(Condition.exist);
    }

}