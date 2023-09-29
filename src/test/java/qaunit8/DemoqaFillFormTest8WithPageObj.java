package qaunit8;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFillFormTest8WithPageObj extends TestBase{

    String userFirstName = "UserFirstName";
    String userLastName = "UserLastName";
    String userEmail = "user_mail@mail.com";
    String userGender = "Female";
    String userAddress = "User Address. City One.";
    String userMobile = "9991234560";
    String userMobileBad = "99912560";
    String[] userDateBirth = {"11","November","1979"};
    String[] userSubjects={"Maths","Physics"};
    String[] userHobbies= {"Sports","Reading"};
    String userState = "NCR";
    String userCity = "Delhi";
    @Test
    void fillFields() {
        registrationPage
                .openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userMobile)
                .setDateOfBirth(userDateBirth[0],userDateBirth[1],userDateBirth[2])
                .setSubject(userSubjects[0],userSubjects[1])
                .setHobbies(userHobbies[0],userHobbies[1])
                .uploadPicture("img/AtomicHeart_sample.jpg")
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submitButtonClick();

        registrationPage
                .checkResultModalVisible()
                .checkResultModalTitleHaveMessage("Thanks for submitting the form")
                .checkResult ("Student Name",userFirstName+" "+userLastName)
                .checkResult ("Student Email",userEmail)
                .checkResult ("Gender",userGender)
                .checkResult ("Mobile",userMobile)
                .checkResult ("Date of Birth",userDateBirth[0]+" "+userDateBirth[1]+","+userDateBirth[2])
                .checkResult ("Subjects",userSubjects[0]+", "+userSubjects[1])
                .checkResult ("Hobbies",userHobbies[0]+", "+userHobbies[1])
                .checkResult ("Picture","AtomicHeart_sample.jpg")
                .checkResult ("Address",userAddress)
                .checkResult ("State and City",userState+" "+userCity)
                .closeResultModal();

    }
    @Test
    public void successRegisterRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setGender(userGender)
                .setUserNumber(userMobile)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage("Thanks for submitting the form")
                .checkResult("Student Name", userFirstName + " " + userLastName)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userMobile);
    }

    @Test
    public void closeModalWindowTest() {
        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setGender(userGender)
                .setUserNumber(userMobile)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage("Thanks for submitting the form")
                .closeResultModal()
                .checkResultModalHidden();
    }

    @Test
    public void negativeRegisterWrongPhoneTest() {
        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setGender(userGender)
                .setUserNumber(userMobileBad)
                .submitButtonClick();

        registrationPage.checkResultModalHidden();
    }
    @Test
    public void negativeRegisterEmptyFieldsTest() {
        registrationPage.openPage()
                .submitButtonClick();

        registrationPage.checkResultModalHidden();
    }

}
