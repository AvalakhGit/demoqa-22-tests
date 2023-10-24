import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser="edge";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
    @Test
    void signUpForNewsletterModalIsOpened() {
        open("https://www.nationalgeographic.com/");
        $x("//a[text()='Newsletters']").shouldBe(visible).click();
        $x("//h1[@class='NewsletterSignup__Title']").shouldHave(text("Sign Up for National Geographic Newsletters"));
        //$$x("//button[@class='Button Button--default CheckCard__Button']").get(0).click();
        $x("//div[@class='CheckCard__Title' and text()='Animals']//parent::*//following-sibling::button").shouldBe(visible).click();
        sleep(500);
        $x("//div[@class='CheckCard__Title' and text()='Animals']//parent::*//following-sibling::button").shouldBe(visible).click();
        sleep(5000);
    }
}
