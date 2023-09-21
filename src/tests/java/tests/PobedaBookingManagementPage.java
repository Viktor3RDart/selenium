package tests;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PobedaBookingManagementPage {

    private SelenideElement lastNameField = $(byXpath("(//*[@id=\"__next\"]//div/input)[1]"));

    private SelenideElement ticketNumberField = $(byXpath("(//*[@id=\"__next\"]//div/input)[2]"));

    private SelenideElement searchButton = $("div.dp-kpzb49-root > button");

    public SelenideElement getLastNameField() {
        return lastNameField;
    }

    public void setLastNameField(SelenideElement lastNameField) {
        this.lastNameField = lastNameField;
    }

    public SelenideElement getTicketNumberField() {
        return ticketNumberField;
    }

    public void setTicketNumberField(SelenideElement ticketNumberField) {
        this.ticketNumberField = ticketNumberField;
    }

    public SelenideElement getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(SelenideElement searchButton) {
        this.searchButton = searchButton;
    }
}
