package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PobedaBookingManagementPage {

    WebDriver driver;

    @FindBy(xpath = "(//*[@id=\"__next\"]//div/input)[1]")
    public
    WebElement lastNameField;

    @FindBy(xpath = "(//*[@id=\"__next\"]//div/input)[2]")
    public
    WebElement ticketNumberField;

    @FindBy(css = "div.dp-kpzb49-root > button")
    public
    WebElement searchButton;


    public PobedaBookingManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillFiled(WebElement element, String info) {
        element.sendKeys(info);
    }
}
