package qaunit12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureUsingLoggerLambdaTest extends TestBase{

    private static final String REPO="eroshenkoam/allure-example";
    @Test
    public void allureUsingTest(){

        SelenideLogger.addListener("allure",new AllureSelenide());
        step("Открываем главную страницу", () ->{
            open("https://github.com");
        });

        step ("Ищем репозиторий",()->{
            $x("//span[@data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys(REPO);
            $("#query-builder-test").pressEnter();
        });

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $("#issue_84").should(Condition.exist);
    }
}
