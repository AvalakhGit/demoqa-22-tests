package qaunit12;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static qaunit12.TestData.PAGE_URL;

public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser="edge";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl=PAGE_URL;
    }

    @AfterAll
    static void tearDown(){
        System.out.println("All done.");
    }

}
