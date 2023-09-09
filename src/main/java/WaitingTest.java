import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Необходимо написать авто тест, выполняющий следующие действия:
//
//Открыть сайт google.com и ввести в строку поиска «Сайт компании Победа», после чего нажать Enter.
//Дождаться прогрузки страницы с результатами поиска, после чего кликнуть на первую ссылку (https://www.pobeda.aero/).
//Дождаться прогрузки страницы АК «Победа», после чего дождаться появления картинки с текстом «Полетели в Калининград»
// и проверить, что текст на странице действительно совпадает с текстом «Полетели в Калининград».
//Кликнуть на переключатель языка, выбрать английский язык и убедиться, что на главной странице отображаются тексты
// "Ticket search", "Online check-in", "Manage my booking"

public class WaitingTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500, 800));
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.google.com/");
    }

    @Test
    public void WaitingTask() {
        Assert.assertEquals(driver.getTitle(), "Google");
        WebElement input = driver.findElement(By.cssSelector("[aria-label=\"Найти\"]"));
        input.click();
        input.sendKeys("Сайт компании Победа");
        input.sendKeys(Keys.ENTER);

        WebElement first_link_aero = driver.findElement(By.xpath("(//*[@id=\"rso\"]//a/h3)[1]"));
        first_link_aero.click();

        WebElement go_kalina = driver.findElement(By.xpath("//*[@id=\"__next\"]//button[10]/div[3]/div/div"));
        //Стандартное явное ожидание - wait.until(ExpectedConditions.visibilityOf(go_kalina));
        // Собственное явное ожидание:
        waitVisibleElement(go_kalina, 80000);
        Assert.assertEquals(go_kalina.getText(), "Полетели в Калининград!");

        WebElement button_language = driver.findElement(By.cssSelector("button.dp-1a5xm0y-root-root"));
        button_language.click();
        WebElement buttonChangeToEn = driver.findElement(By.cssSelector("div.dp-1s529v0-root-root > * button:nth-child(2)"));
        buttonChangeToEn.click();
        WebElement EnButtonSearch = driver.findElement(By.xpath("//*[@id=\"__next\"]//div[2]/button[1]/div[1]"));
        WebElement EnButtonOnline = driver.findElement(By.xpath("//*[@id=\"__next\"]//div[2]/button[2]/div[1]"));
        WebElement EnButtonManage = driver.findElement(By.xpath("//*[@id=\"__next\"]//div[2]/button[3]/div[1]"));
        wait.until(ExpectedConditions.textToBePresentInElement(EnButtonSearch, "Ticket search"));
        Assert.assertEquals(EnButtonSearch.getText(), "Ticket search");
        Assert.assertEquals(EnButtonOnline.getText(), "Online check-in");
        Assert.assertEquals(EnButtonManage.getText(), "Manage my booking");
    }

    public static void waitVisibleElement(WebElement element, float time) {
        float waitingTime = 0;
        long startLoadingTime = System.currentTimeMillis();
        while (!element.isDisplayed()) {
            if (waitingTime <= time) {
                waitingTime = System.currentTimeMillis() - startLoadingTime;
            } else {
                System.out.println("Condition wasn't executed with time");
                break;
            }
        }
        if (element.isDisplayed()) {
            System.out.println("Condition was executed in " + (waitingTime / 1000) + " seconds");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
