package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.DropDownULComponent;
import pages.components.ModalResultWindow;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    DropDownULComponent dropDownUL = new DropDownULComponent();
    ModalResultWindow resultTableWindow = new ModalResultWindow();

    //Selenide Elements
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbieSelect = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddr = $("#currentAddress"),
            setState = $("#state"),
            setCity = $("#city"),
            submitButton = $("#submit");


    //Actions

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String... subject) {

        for (String subj : subject) {
            subjectInput.setValue(subj).sendKeys(Keys.ENTER);
        }
        return this;
    }

    public RegistrationPage setHobbies(String... hobbies) {
        for (String hobbie : hobbies) {
            hobbieSelect.$(byText(hobbie)).click();
        }
        return this;
    }

    public RegistrationPage uploadPicture(String path) {

        uploadPicture.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddr.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        setState.click();
        dropDownUL.selectValue(setState, value);
        return this;
    }

    public RegistrationPage setCity(String value) {
        setCity.click();
        dropDownUL.selectValue(setCity, value);
        return this;
    }

    public void submitButtonClick() {
        submitButton.click();
    }

    public RegistrationPage checkResultModalVisible() {
        resultTableWindow.checkVisible();
        return this;
    }

    public RegistrationPage checkResultModalHidden() {
        resultTableWindow.checkHidden();
        return this;
    }

    public RegistrationPage checkResultModalTitleHaveMessage(String messages) {
        resultTableWindow.checkTitleMessage(messages);
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultTableWindow.checkResult(key, value);
        return this;
    }

    public RegistrationPage closeResultModal() {
        resultTableWindow.close();
        return this;
    }


}
