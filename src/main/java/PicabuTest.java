import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


//Написать авто тест, который выполняет следующий набор действий:
//
//        Перейти на сайт «https://pikabu.ru/».
//        Убедиться, что заголовок сайта: «Горячее – самые интересные и обсуждаемые посты | Пикабу».
//        Кликнуть на кнопку «Войти».
//        Убедиться, что отображается модальное окно «Авторизация», отображаются поля «Логин» и «Пароль», отображается кнопка «Войти».
//        Ввести в поля данные в формате логин/пароль – Qwerty/Qwerty и нажать «Войти».
//        Убедиться, что появилось сообщение об ошибке, и его текст: «Ошибка. Вы ввели неверные данные авторизации».


public class PicabuTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500,800));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://pikabu.ru/");

    }

    @Test
    public void PicabuTestTask() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://pikabu.ru/");
        Assert.assertEquals(driver.getTitle(), "Горячее – самые интересные и обсуждаемые посты | Пикабу");
        WebElement button_enter = driver.findElement(By.className("header-right-menu__login-button"));
        button_enter.click();

        WebElement button_enter_modal = driver.findElement(By.xpath("//div[2]/div[1]/div/div[1]/div[2]/form/div[7]/button/span"));
        WebElement modal_window = driver.findElement(By.className("auth-modal"));
        WebElement modal_password = driver.findElement(By.xpath("(//*[@id=\"signin-form\"]/div[2]/div/div/input)[2]"));
        WebElement modal_login = driver.findElement(By.xpath("(//*[@id=\"signin-form\"]/div[1]/div/div/input)[2]"));

        Assert.assertTrue(modal_window.isDisplayed());
        Assert.assertTrue(modal_login.isDisplayed());
        Assert.assertTrue(modal_password.isDisplayed());
        Assert.assertTrue(button_enter_modal.isDisplayed());

        modal_login.click();
        modal_login.sendKeys("Qwerty");

        modal_password.click();
        modal_password.sendKeys("Qwerty");

        button_enter_modal.click();
        // Ожидание появления надписи об ошибке. Иногда там бывает reCapcha, ее обойти не получилось только вручную вводить,
        // для этого ожидание было увеличено с 2 до 10 секунд, если капчи нет то 2 секунд ожидания достаточно.
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("div.popup__content > div > span"),""));
        WebElement modal_error_auth = driver.findElement(By.cssSelector("div.popup__content > div > span"));
        Assert.assertEquals(modal_error_auth.getText(), "Ошибка. Вы ввели неверные данные авторизации");
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
