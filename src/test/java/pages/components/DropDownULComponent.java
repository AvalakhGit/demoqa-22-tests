package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class DropDownULComponent {
    public void selectValue(SelenideElement dropDownUL, String value) {
        dropDownUL.$(byText(value)).click();
    }
}
