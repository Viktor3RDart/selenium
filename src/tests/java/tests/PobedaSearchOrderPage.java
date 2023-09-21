package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class PobedaSearchOrderPage {

    private SelenideElement errorMessage = $("div.message_error");

    @Step("Переключится на вкладку № {numberWindow}")
    public void goToNextTab(int numberWindow) {
        switchTo().window(numberWindow);
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(SelenideElement errorMessage) {
        this.errorMessage = errorMessage;
    }
}