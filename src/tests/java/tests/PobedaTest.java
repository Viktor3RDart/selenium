package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


import static tests.PobedaTestData.*;

public class PobedaTest extends PobedaHomePage {


    @BeforeEach
    public void setUp() {
        openPage(HOME_PAGE);
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
        getTitleLogo().should(Condition.visible);
        checkField(giveTitleText(), TEST_TITLE_HOME_PAGE);
        checkVisibility(getTitleLogo());
        goToSomeButton(getInfoButton());
        getReadyToFlyButton().shouldBe(Condition.visible);
        checkField(giveText(getReadyToFlyButton()), "Подготовка к полёту");
        checkField(getGoodInfoButton().getText(), "Полезная информация");
        checkField(getAboutCompanyButton().getText(), "О компании");
    }

    //    //1. Перейти на сайт pobeda.aero.
//    //2. Убедиться, что сайт открылся:
//    //а) текст заголовка страницы: Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые
//    // и трансферные рейсы;
//    //б) на странице есть логотип Победы.
//    //3. Проскроллить страницу к блоку поиска билета и убедиться, что блок с поиском билета действительно
//    // отображается (есть поле Откуда, Куда, Дата вылета Туда, Дата вылета Обратно)
//    //4. Выбрать (или ввести) следующие критерии поиска:
//    //откуда – Москва (без выбора аэропорта) + нажать Enter
//    //куда – Санкт-Петербург + нажать Enter.
//    //6. Нажать кнопку «Поиск».
//    //7. Убедиться, что около поля «Туда» появилась красная обводка.
//
    @Test
    public void PobedaTaskTest_2() {
        getTitleLogo().should(Condition.visible);
        checkField(giveTitleText(), TEST_TITLE_HOME_PAGE);
        checkVisibility(getTitleLogo());
        scrollTo(getTicketsBox());
        checkVisibility(getTicketFieldFrom());
        checkField(getNameTicketsField(getTicketFieldFrom(), "placeholder"), "Откуда");
        checkVisibility(getTicketFieldTo());
        checkField(getNameTicketsField(getTicketFieldTo(), "placeholder"), "Куда");
        checkVisibility(getTicketFieldDateIn());
        checkField(getNameTicketsField(getTicketFieldDateIn(), "placeholder"), "Туда");
        checkVisibility(getTicketFieldDateBack());
        checkField(getNameTicketsField(getTicketFieldDateBack(), "placeholder"), "Обратно");
        sendKeys(getTicketFieldFrom(), "Москва");
        clickElement(getFirstElementInField());
        sendKeys(getTicketFieldTo(), "Санкт-Петербург");
        clickElement(getFirstElementInField());
        clickElement(getFindTicketsButton());
        checkField(giveColorOf(getTicketFieldDateInFrame()), "rgba(213, 0, 98, 1)");
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
        PobedaBookingManagementPage PbmPage = new PobedaBookingManagementPage();
        PobedaSearchOrderPage PsoPage = new PobedaSearchOrderPage();
        getTitleLogo().should(Condition.visible);
        checkField(giveTitleText(), TEST_TITLE_HOME_PAGE);
        checkVisibility(getTitleLogo());
        // Так как на экране "Управление бронированием" закрыто рекламой, то нужно прокрутить ниже в конец страницы.
        scrollTo(getDownToPage());
        clickElement(getManageYourBooking());
        PbmPage.getSearchButton().shouldBe(Condition.interactable);
        checkVisibility(PbmPage.getLastNameField());
        checkVisibility(PbmPage.getTicketNumberField());
        checkVisibility(PbmPage.getSearchButton());
        sendKeys(PbmPage.getLastNameField(), "Qwerty");
        sendKeys(PbmPage.getTicketNumberField(), "XXXXXX");
        clickElement(PbmPage.getSearchButton());
        PsoPage.goToNextTab(1);
        PsoPage.getErrorMessage().shouldBe(Condition.visible);
        checkField(giveText(PsoPage.getErrorMessage()), "Заказ с указанными параметрами не найден");
    }
}