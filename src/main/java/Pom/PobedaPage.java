package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PobedaPage {

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

    public PobedaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  String giveTitleText() {
        return driver.getTitle();
    }

    public void goToInfoButton(){
        Actions ac = new Actions(driver);
        ac.moveToElement(infoButton).perform();
    }


}
