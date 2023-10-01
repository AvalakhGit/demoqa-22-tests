package qaunit8;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void tearDown() {
        System.out.println("All done.");
    }

}
