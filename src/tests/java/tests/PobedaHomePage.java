package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PobedaHomePage {

    private SelenideElement titleLogo = $(byXpath("//*[@id=\"__next\"]/div[2]//div[2]/div[1]/div/a/img"));

    private SelenideElement infoButton = $("div.dp-1mfa3ct-root-root > div.dp-1vo6aoh-root > a:nth-child(1)");

    private SelenideElement readyToFlyButton = $(By.xpath("//*[@id=\"__next\"]//div[2]//div[2]/div/div/div/div[1]/a"));

    private SelenideElement goodInfoButton = $(byXpath("//*[@id=\"__next\"]/div[2]//div[2]/div[2]/div[2]/div/div/div/div[2]/a"));

    private SelenideElement aboutCompanyButton = $(byXpath("//*[@id=\"__next\"]//div[2]//div[2]/div/div/div/div[3]/a"));

    private SelenideElement ticketsBox = $(byClassName("dp-yvfgrg-root-card"));

    private SelenideElement ticketFieldFrom = $("div:nth-child(1) > div > div > input");

    private SelenideElement ticketFieldTo = $("div:nth-child(4) > div > div > input");

    private SelenideElement ticketFieldDateIn = $("div.dp-1pr8ed5-root > div > div:nth-child(1) > div > input");

    private SelenideElement ticketFieldDateInFrame = $("div.dp-iqepeq-root > div > " +
            "div.dp-192lqng-root > div.dp-1riiepc-root > div > div:nth-child(1) > div");

    private SelenideElement ticketFieldDateBack = $("div.dp-1pr8ed5-root > div > div:nth-child(3) > div > input");

    private SelenideElement findTicketsButton = $(byClassName("dp-82lagl-root-root"));

    private SelenideElement firstElementInField = $(byClassName("dp-vgaeps-root-suggestionName"));

    private SelenideElement manageYourBooking = $(byLinkText("Управление бронированием"));

    private SelenideElement downToPage = $(" div.dp-153bccs-root > div");

    @Step("Получение титула страницы")
    public String giveTitleText() {
        return title();
    }

    @Step("Наведение мышки на элемент - {element}")
    public void goToSomeButton(SelenideElement element) {
        element.hover();
    }

    @Step("Прокрутка страницы до элемента - {element}")
    public void scrollTo(SelenideElement element) {
        element.scrollTo();
    }

    @Step("Запрос имени поля элемента - {element}")
    public String getNameTicketsField(SelenideElement element, String nameAttribute) {
        return element.getAttribute(nameAttribute);
    }

    @Step("Клик по элементу {element}")
    public void clickElement(SelenideElement element) {
        element.click();
    }

    @Step("Ввод в поле значения {writeInElement}")
    public void sendKeys(SelenideElement element, String info) {
        element.sendKeys(info);
        // По условию тут должен быть ENTER дальше, но так не работает, надо выбрать из селекта.
        clickElement(firstElementInField);
    }

    @Step("Цвет элемента - {element}")
    public String giveColorOf(SelenideElement element) {
        return element.getCssValue("border-bottom-color");
    }


    @Step("Проверка соответствия введенного элемента {expected} и полученного {actual}")
    public void checkField(String expected, String actual) {
        Assert.assertEquals(expected, actual);
    }

    @Step("Проверка отображение элемента - {element}")
    public boolean checkVisibility(SelenideElement element) {
        return element.isDisplayed();
    }

    @Step("Получить текст элемента - {element}")
    public String giveText(SelenideElement element) {
        return element.getText();
    }

    public SelenideElement getTitleLogo() {
        return titleLogo;
    }

    public void setTitleLogo(SelenideElement titleLogo) {
        this.titleLogo = titleLogo;
    }

    public SelenideElement getInfoButton() {
        return infoButton;
    }

    public void setInfoButton(SelenideElement infoButton) {
        this.infoButton = infoButton;
    }

    public SelenideElement getReadyToFlyButton() {
        return readyToFlyButton;
    }

    public void setReadyToFlyButton(SelenideElement readyToFlyButton) {
        this.readyToFlyButton = readyToFlyButton;
    }

    public SelenideElement getGoodInfoButton() {
        return goodInfoButton;
    }

    public void setGoodInfoButton(SelenideElement goodInfoButton) {
        this.goodInfoButton = goodInfoButton;
    }

    public SelenideElement getAboutCompanyButton() {
        return aboutCompanyButton;
    }

    public void setAboutCompanyButton(SelenideElement aboutCompanyButton) {
        this.aboutCompanyButton = aboutCompanyButton;
    }

    public SelenideElement getTicketsBox() {
        return ticketsBox;
    }

    public void setTicketsBox(SelenideElement ticketsBox) {
        this.ticketsBox = ticketsBox;
    }

    public SelenideElement getTicketFieldFrom() {
        return ticketFieldFrom;
    }

    public void setTicketFieldFrom(SelenideElement ticketFieldFrom) {
        this.ticketFieldFrom = ticketFieldFrom;
    }

    public SelenideElement getTicketFieldTo() {
        return ticketFieldTo;
    }

    public void setTicketFieldTo(SelenideElement ticketFieldTo) {
        this.ticketFieldTo = ticketFieldTo;
    }

    public SelenideElement getTicketFieldDateIn() {
        return ticketFieldDateIn;
    }

    public void setTicketFieldDateIn(SelenideElement ticketFieldDateIn) {
        this.ticketFieldDateIn = ticketFieldDateIn;
    }

    public SelenideElement getTicketFieldDateInFrame() {
        return ticketFieldDateInFrame;
    }

    public void setTicketFieldDateInFrame(SelenideElement ticketFieldDateInFrame) {
        this.ticketFieldDateInFrame = ticketFieldDateInFrame;
    }

    public SelenideElement getTicketFieldDateBack() {
        return ticketFieldDateBack;
    }

    public void setTicketFieldDateBack(SelenideElement ticketFieldDateBack) {
        this.ticketFieldDateBack = ticketFieldDateBack;
    }

    public SelenideElement getFindTicketsButton() {
        return findTicketsButton;
    }

    public void setFindTicketsButton(SelenideElement findTicketsButton) {
        this.findTicketsButton = findTicketsButton;
    }

    public SelenideElement getFirstElementInField() {
        return firstElementInField;
    }

    public void setFirstElementInField(SelenideElement firstElementInField) {
        this.firstElementInField = firstElementInField;
    }

    public SelenideElement getManageYourBooking() {
        return manageYourBooking;
    }

    public void setManageYourBooking(SelenideElement manageYourBooking) {
        this.manageYourBooking = manageYourBooking;
    }

    public SelenideElement getDownToPage() {
        return downToPage;
    }

    public void setDownToPage(SelenideElement downToPage) {
        this.downToPage = downToPage;
    }
}