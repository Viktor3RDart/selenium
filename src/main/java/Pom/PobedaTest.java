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
    PobedaHomePage homePage;
    PobedaBookingManagementPage PbmPage;
    PobedaSearchOrderPage PsoPage;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500, 800));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
        homePage = new PobedaHomePage(driver);

        wait.until(ExpectedConditions.visibilityOf(homePage.titleLogo));

        Assert.assertEquals(homePage.giveTitleText(), "Авиакомпания «Победа» - купить билеты на самолёт дешево" +
                " онлайн, прямые и трансферные рейсы");
        Assert.assertTrue(homePage.titleLogo.isDisplayed());

        homePage.goToSomeButton(homePage.infoButton);
        wait.until(ExpectedConditions.visibilityOf(homePage.readyToFlyButton));
        Assert.assertEquals(homePage.readyToFlyButton.getText(), "Подготовка к полёту");
        Assert.assertEquals(homePage.goodInfoButton.getText(), "Полезная информация");
        Assert.assertEquals(homePage.aboutCompanyButton.getText(), "О компании");
    }

    //1. Перейти на сайт pobeda.aero.
    //2. Убедиться, что сайт открылся:
    //а) текст заголовка страницы: Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые
    // и трансферные рейсы;
    //б) на странице есть логотип Победы.
    //3. Проскроллить страницу к блоку поиска билета и убедиться, что блок с поиском билета действительно
    // отображается (есть поле Откуда, Куда, Дата вылета Туда, Дата вылета Обратно)
    //4. Выбрать (или ввести) следующие критерии поиска:
    //откуда – Москва (без выбора аэропорта) + нажать Enter
    //куда – Санкт-Петербург + нажать Enter.
    //6. Нажать кнопку «Поиск».
    //7. Убедиться, что около поля «Туда» появилась красная обводка.

    @Test
    public void PobedaTaskTest_2() {
        homePage = new PobedaHomePage(driver);

        wait.until(ExpectedConditions.visibilityOf(homePage.titleLogo));
        Assert.assertEquals(homePage.giveTitleText(), "Авиакомпания «Победа» - купить билеты на самолёт дешево" +
                " онлайн, прямые и трансферные рейсы");
        Assert.assertTrue(homePage.titleLogo.isDisplayed());

        homePage.scrollTo(homePage.ticketsBox);
        Assert.assertTrue(homePage.ticketFieldFrom.isDisplayed());
        Assert.assertEquals(homePage.getNameTicketsField(homePage.ticketFieldFrom, "placeholder"), "Откуда");
        Assert.assertTrue(homePage.ticketFieldTo.isDisplayed());
        Assert.assertEquals(homePage.getNameTicketsField(homePage.ticketFieldTo, "placeholder"), "Куда");
        Assert.assertTrue(homePage.ticketFieldDateIn.isDisplayed());
        Assert.assertEquals(homePage.getNameTicketsField(homePage.ticketFieldDateIn, "placeholder"), "Туда");
        Assert.assertTrue(homePage.ticketFieldDateBack.isDisplayed());
        Assert.assertEquals(homePage.getNameTicketsField(homePage.ticketFieldDateBack, "placeholder"), "Обратно");

        homePage.fillFiled(homePage.ticketFieldFrom, "Москва");
        homePage.fillFiled(homePage.ticketFieldTo, "Санкт-Петербург");
        homePage.findTickets();
        Assert.assertEquals(homePage.giveColorOf(homePage.ticketFieldDateInFrame), "rgba(213, 0, 98, 1)");
    }


    //1. Перейти на сайт pobeda.aero.
    //2. Убедиться, что сайт открылся:
    //а) текст заголовка страницы: Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы;
    //б) на странице есть логотип Победы.
    //3. Проскроллить страницу чуть ниже и кликнуть на пункт «Управление бронированием».
    //4. Убедиться, что открылась необходимая страница:
    //а) есть поле «Номер заказа или билета»;
    //б) есть поле «Фамилия клиента»;
    //в) есть кнопка «Поиск».
    //5. Ввести в поля ввода данные:
    //номер заказа – XXXXXX, фамилия – Qwerty
    //и нажать кнопку «Поиск».
    //6. Убедиться, что в новой вкладке на экране отображается текст ошибки «Заказ с указанными параметрами не найден»

    @Test
    public void PobedaTaskTest_3() {
        homePage = new PobedaHomePage(driver);
        PbmPage = new PobedaBookingManagementPage(driver);
        PsoPage = new PobedaSearchOrderPage(driver);

        wait.until(ExpectedConditions.visibilityOf(homePage.titleLogo));
        Assert.assertEquals(homePage.giveTitleText(), "Авиакомпания «Победа» - купить билеты на самолёт дешево" +
                " онлайн, прямые и трансферные рейсы");
        Assert.assertTrue(homePage.titleLogo.isDisplayed());
        // Так как на экране "Управление бронированием" закрыто рекламой, то нужно прокрутить ниже в конец страницы.
        homePage.scrollTo(homePage.downToPage);
        homePage.manageYourBooking.click();

        wait.until(ExpectedConditions.elementToBeClickable(PbmPage.searchButton));
        PbmPage.lastNameField.isDisplayed();
        PbmPage.ticketNumberField.isDisplayed();
        PbmPage.searchButton.isDisplayed();
        PbmPage.fillFiled(PbmPage.lastNameField, "Qwerty");
        PbmPage.fillFiled(PbmPage.ticketNumberField, "XXXXXX");
        PbmPage.searchButton.click();

        PsoPage.goToNextTab();
        wait.until(ExpectedConditions.visibilityOf(PsoPage.errorMessage));
        Assert.assertEquals(PsoPage.errorMessage.getText(), "Заказ с указанными параметрами не найден");
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
