package qaunit8;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFillFormTest8WithPageObj extends TestBase{



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



        registrationPage
                .openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userMobile)
                .setDateOfBirth(userDateBirth[0],userDateBirth[1],userDateBirth[2]);


        $("#subjectsInput").setValue(userSubjects[0]).pressEnter();
        $("#subjectsInput").setValue(userSubjects[1]).pressEnter();

        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();

        $("#uploadPicture").uploadFromClasspath("img/AtomicHeart_sample.jpg");

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
                text(userState+" "+userCity));

        registrationPage.checkResult ("Students name",userFirstName+" "+userLastName);
        registrationPage.checkResult ("Student Email",userEmail);
        registrationPage.checkResult ("Gender",userGender);
        registrationPage.checkResult ("Mobile",userMobile);
        registrationPage.checkResult ("Date of Birth",userDateBirth[0]+" "+userDateBirth[1]+","+userDateBirth[2]);
        registrationPage.checkResult ("Subjects",userSubjects[0]+", "+userSubjects[1]);
        registrationPage.checkResult ("Hobbies",userHobbies[0]+", "+userHobbies[1]);
        registrationPage.checkResult ("Picture","AtomicHeart_sample.jpg");
        registrationPage.checkResult ("Address",userAddress);
        registrationPage.checkResult ("State and City",userState+" "+userCity);


        $("#closeLargeModal").click();
    }

}
