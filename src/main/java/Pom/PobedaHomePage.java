package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PobedaHomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]//div[2]/div[1]/div/a/img")
    public
    WebElement titleLogo;

    @FindBy(css = "div.dp-1mfa3ct-root-root > div.dp-1vo6aoh-root > a:nth-child(1)")
    WebElement infoButton;

    @FindBy(xpath = "//*[@id=\"__next\"]//div[2]//div[2]/div/div/div/div[1]/a")
    public WebElement readyToFlyButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]//div[2]/div[2]/div[2]/div/div/div/div[2]/a")
    public WebElement goodInfoButton;

    @FindBy(xpath = "//*[@id=\"__next\"]//div[2]//div[2]/div/div/div/div[3]/a")
    public WebElement aboutCompanyButton;

    @FindBy(className = "dp-yvfgrg-root-card")
    public WebElement ticketsBox;

    @FindBy(css = "div:nth-child(1) > div > div > input")
    public WebElement ticketFieldFrom;

    @FindBy(css = "div:nth-child(4) > div > div > input")
    public WebElement ticketFieldTo;

    @FindBy(css = "div.dp-1pr8ed5-root > div > div:nth-child(1) > div > input")
    public WebElement ticketFieldDateIn;

    @FindBy(css = "div.dp-iqepeq-root > div > div.dp-192lqng-root > div.dp-1riiepc-root > div > div:nth-child(1) > div")
    public WebElement ticketFieldDateInFrame;

    @FindBy(css = "div.dp-1pr8ed5-root > div > div:nth-child(3) > div > input")
    public WebElement ticketFieldDateBack;

    @FindBy(className = "dp-82lagl-root-root")
    public WebElement findTicketsButton;

    @FindBy(className = "dp-vgaeps-root-suggestionName")
    public WebElement firstElementInField;

    @FindBy(linkText = "Управление бронированием")
    public WebElement manageYourBooking;

    @FindBy(css = " div.dp-153bccs-root > div")
    public WebElement downToPage;

    public PobedaHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String giveTitleText() {
        return driver.getTitle();
    }

    public void goToSomeButton(WebElement element) {
        Actions ac = new Actions(driver);
        ac.moveToElement(element).perform();
    }

    public void scrollTo(WebElement element) {
        Actions ac = new Actions(driver);
        ac.scrollToElement(element).perform();
    }

    public String getNameTicketsField(WebElement element, String nameAttribute) {
        return element.getAttribute(nameAttribute);
    }

    public void fillFiled(WebElement element, String info) {
        element.sendKeys(info);
        // По условию тут должен быть ENTER дальше, но так не работает, надо выбрать из селекта.
        firstElementInField.click();
    }

    public String giveColorOf(WebElement element) {
        return element.getCssValue("border-bottom-color");
    }

    public void findTickets() {
        findTicketsButton.click();
    }
}
