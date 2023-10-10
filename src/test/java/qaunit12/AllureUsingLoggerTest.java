package qaunit12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLog;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class AllureUsingLoggerTest extends TestBase{

    @Test
    public void allureUsingTest(){

        SelenideLogger.addListener("allure",new AllureSelenide());
        open("https://github.com");

        $x("//span[@data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $("#issue_84").should(Condition.exist);
    }
}
