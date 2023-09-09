import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StrangeThingsTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void StrangeThingsGoogle() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");
        WebElement input = driver.findElement(By.cssSelector("[aria-label=\"Найти\"]"));
        input.click();
        input.sendKeys("Очень странные дела");
        input.sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Очень странные дела - Поиск в Google");
        WebElement input2 = driver.findElement(By.cssSelector("[aria-label=\"Найти\"]"));
        String text = input2.getAttribute("value");
        Assert.assertEquals(text, "Очень странные дела");
        WebElement logo = driver.findElement(By.cssSelector("img[alt=\"Google\"]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
