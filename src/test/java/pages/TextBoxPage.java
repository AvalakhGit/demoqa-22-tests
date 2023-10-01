package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.OutputComponent;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    OutputComponent output = new OutputComponent();

    SelenideElement fullNameInput = $("#userName"),
            userEmail = $("#userEmail"),
            userAddress = $("#currentAddress"),
            userPermanentAddress = $("#permanentAddress"),
            submitButton = $("#submit");

    public TextBoxPage openPage() {
        open("https://demoqa.com/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        userAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        userPermanentAddress.setValue(value);
        return this;
    }

    public void submitButtonClick() {
        submitButton.click();
    }

    public TextBoxPage checkOutputVisible() {
        output.checkVisible();
        return this;
    }

    public TextBoxPage checkOutputHidden() {
        output.checkHidden();
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        output.checkResult(key, value);
        return this;
    }
}
