package qaunit9;

import org.junit.jupiter.api.Test;

import static qaunit9.TestData.*;

public class RegFormWithFakerTests extends TestBase {
    @Test
    public void registrationFormFillAllFieldsAndCheck() {
        String userFirstName=getUserFirstName();
        String userLastName=getUserLastName();

        registrationPage
                .openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(getUserEmail(userFirstName+"."+userLastName))
                .setGender(getRandomGender())
                .setUserNumber(getUserMobile(10))
                .setDateOfBirth(userDateBirth[0],userDateBirth[1],userDateBirth[2])
                .setSubject(userSubjects[0],userSubjects[1])
                .setHobbies(userHobbies[0],userHobbies[1])
                .uploadPicture("img/AtomicHeart1.jpg")
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
