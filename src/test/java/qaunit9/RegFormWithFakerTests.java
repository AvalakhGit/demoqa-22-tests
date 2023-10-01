package qaunit9;

import org.junit.jupiter.api.Test;

public class RegFormWithFakerTests extends TestBase {
    @Test
    public void registrationFormFillAllFieldsAndCheck() {
        registrationPage
            .openPage()
            .setFirstName(testData.userFirstName)
            .setLastName(testData.userLastName)
            .setEmail(testData.userEmail)
            .setGender(testData.userGender)
            .setUserNumber(testData.userMobile)
            .setDateOfBirth(testData.userDateBirth[0],
                    testData.userDateBirth[1],
                    testData.userDateBirth[2])
            .setSubject(testData.userSubject)
            .setHobbies(testData.userHobbie)
            .uploadPicture("img/"+testData.picturePath)
            .setAddress(testData.userAddress)
            .setState(testData.userState)
            .setCity(testData.userCity)
            .submitButtonClick();

        registrationPage
            .checkResultModalVisible()
            .checkResultModalTitleHaveMessage("Thanks for submitting the form")
            .checkResult ("Student Name",testData.userFirstName+" "+testData.userLastName)
            .checkResult ("Student Email",testData.userEmail)
            .checkResult ("Gender",testData.userGender)
            .checkResult ("Mobile",testData.userMobile)
            .checkResult ("Date of Birth",
                    testData.userDateBirth[0]+" "+
                    testData.userDateBirth[1]+","+
                    testData.userDateBirth[2])
            .checkResult ("Subjects",testData.userSubject)
            .checkResult ("Hobbies",testData.userHobbie)
            .checkResult ("Picture",testData.picturePath)
            .checkResult ("Address",testData.userAddress)
            .checkResult ("State and City",testData.userState+" "+testData.userCity)
            .closeResultModal();
    }
    @Test
    public void successRegisterRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(testData.userFirstName)
                .setLastName(testData.userLastName)
                .setGender(testData.userGender)
                .setUserNumber(testData.userMobile)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage("Thanks for submitting the form")
                .checkResult ("Student Name",testData.userFirstName+" "+testData.userLastName)
                .checkResult ("Gender",testData.userGender)
                .checkResult ("Mobile",testData.userMobile);
    }
    @Test
    public void closeModalWindowTest() {
        registrationPage.openPage()
                .setFirstName(testData.userFirstName)
                .setLastName(testData.userLastName)
                .setGender(testData.userGender)
                .setUserNumber(testData.userMobile)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage("Thanks for submitting the form")
                .closeResultModal()
                .checkResultModalHidden();
    }
    @Test
    public void negativeRegisterWrongPhoneTest() {
        registrationPage.openPage()
                .setFirstName(testData.userFirstName)
                .setLastName(testData.userLastName)
                .setGender(testData.userGender)
//                .setUserNumber(testData.userMobile)
                .setUserNumber(testData.userMobileBad)
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
