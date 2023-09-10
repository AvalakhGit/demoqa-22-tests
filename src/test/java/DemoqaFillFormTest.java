import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFillFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser="edge";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFields() {

        String userFirstName = "UserFirstName";
        String userLastName = "UserLastName";
        String userEmail = "user_mail@mail.com";
        String userGender = "Female";
        String userAddress = "User Address. City One.";
        String userMobile = "9991234560";
        String[] userDateBirth = {"11","November","1979"};
        String[] userSubjects={"Maths","Physics"};
        String[] userHobbies= {"Sports","Reading"};
        String userState = "NCR";
        String userCity = "Delhi";

        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
        $(By.xpath("//input[@name='gender' and @value='"+userGender+"']/following-sibling::label[@class='custom-control-label']")).click();
        $("#userNumber").setValue(userMobile);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(userDateBirth[1]);
        $(".react-datepicker__year-select").selectOption(userDateBirth[2]);
        $(".react-datepicker__day--0"+userDateBirth[0]).click();

        $("#subjectsInput").setValue(userSubjects[0]).pressEnter();
        $("#subjectsInput").setValue(userSubjects[1]).pressEnter();

        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();

        $("#uploadPicture").uploadFromClasspath("AtomicHeart_sample.jpg");

        $("#currentAddress").setValue(userAddress);
        $("#react-select-3-input").setValue(userState).pressEnter();
        $("#react-select-4-input").setValue(userCity).pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(userFirstName+" "+userLastName),
                text(userEmail),
                text(userGender),
                text(userMobile),
                text(userDateBirth[0]+" "+userDateBirth[1]+","+userDateBirth[2]),
                text(userSubjects[0]+", "+userSubjects[1]),
                text(userHobbies[0]+", "+userHobbies[1]),
                text("AtomicHeart_sample.jpg"),
                text(userAddress),
                text(userState+" "+userCity)
        );
        $("#closeLargeModal").click();
    }
    @AfterAll
    static void tearDown(){
        System.out.println("All done.");
    }
}
