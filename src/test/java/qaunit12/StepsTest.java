package qaunit12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends TestBase {
    TestData testData = new TestData();
    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(testData.PAGE_URL);
        });
        step("Ищем репозиторий " + testData.REPO, () -> {
            $(".search-input").click();
            $("#query-builder-test").sendKeys(testData.REPO);
            $("#query-builder-test").pressEnter();
        });
        step("Кликаем по ссылке репозитория " + testData.REPO, () -> {
            $(linkText(testData.REPO)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + testData.ISSUE_NUMBER, () -> {
            $(withText("#" + testData.ISSUE_NUMBER)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(testData.REPO);
        steps.clickOnRepositoryLink(testData.REPO);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(testData.ISSUE_NUMBER);

    }

}