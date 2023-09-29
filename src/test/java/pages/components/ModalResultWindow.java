package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalResultWindow {

    SelenideElement modalWindow = $(".modal-dialog");
    SelenideElement closeButton = $("#closeLargeModal");

    public void checkVisible() {
        modalWindow.should(visible);
    }

    public void checkHidden() {
        modalWindow.should(hidden);
    }

    public void checkTitleMessage(String message) {
        $("#example-modal-sizes-title-lg").shouldHave(text(message));
    }

    public void checkResult(String key, String value) {
        $(".table-responsive")
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
    }

    public void close() {
        closeButton.click();
    }
}
