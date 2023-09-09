import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    @SneakyThrows
    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.ru/");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebElement element = driver.findElement(By.xpath("//*[@id=\"grid\"]//a[6]"));
        element.click();
        Thread.sleep(5000);
        driver.quit();

    }
}
