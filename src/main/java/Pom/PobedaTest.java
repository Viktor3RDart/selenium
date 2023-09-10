package Pom;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class PobedaTest {

    private WebDriver driver;
    private WebDriverWait wait;
    PobedaPage homePage;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500, 800));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://pobeda.aero/");
    }


    //1. Перейти на сайт pobeda.aero.
    //2. Убедиться, что сайт открылся:
    //а) текст заголовка страницы: Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные
    // рейсы;
    //б) на странице есть логотип Победы.
    //3. Навести мышку на пункт «Информация».
    //4. Убедиться, что появилось всплывающее окно, которое содержит следующие заголовки: «Подготовка к полету»,
    // «Полезная информация», «О компании».

    @Test
    public void PobedaTaskTest_1() {
        homePage = new PobedaPage(driver);
        wait.until(ExpectedConditions.visibilityOf(homePage.titleLogo));
        Assert.assertEquals(homePage.giveTitleText(), "Авиакомпания «Победа» - купить билеты на самолёт дешево" +
                " онлайн, прямые и трансферные рейсы");
        Assert.assertTrue(homePage.titleLogo.isDisplayed());
        homePage.goToInfoButton();
        wait.until(ExpectedConditions.visibilityOf(homePage.readyToFlyButton));
        Assert.assertEquals(homePage.readyToFlyButton.getText(), "Подготовка к полёту");
        Assert.assertEquals(homePage.goodInfoButton.getText(), "Полезная информация");
        Assert.assertEquals(homePage.aboutCompanyButton.getText(), "О компании");


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
