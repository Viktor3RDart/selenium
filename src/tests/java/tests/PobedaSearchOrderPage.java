package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.*;

import java.util.ArrayList;


public class PobedaSearchOrderPage {
    WebDriver driver;

    private WebElement errorMessage = $( "div.message_error");

    public void goToNextTab() {
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(WebElement errorMessage) {
        this.errorMessage = errorMessage;
    }
}