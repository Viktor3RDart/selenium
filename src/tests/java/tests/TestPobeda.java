package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.SeverityLevel.NORMAL;
import static tests.PobedaTestData.*;

@Epic("Selenide и Allure")
@Feature("Проверка на сайте победа")
public class TestPobeda extends PobedaHomePage {

    @Step("Подготовка старта драйвера, переход на страницу")
    @BeforeEach
    public void setUp() {
        openPage(HOME_PAGE);
    }

    @DisplayName("Тест №1")
    @Description(value = " " +
            "    1. Перейти на сайт pobeda.aero.\n" +
            "    2. Убедиться, что сайт открылся:\n" +
            "    а) текст заголовка страницы: Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, " +
            "прямые и трансферные рейсы;\n" +
            "    б) на странице есть логотип Победы.\n" +
            "    3. Навести мышку на пункт «Информация».\n" +
            "    4. Убедиться, что появилось всплывающее окно, которое содержит следующие заголовки: " +
            "«Подготовка к полету», «Полезная информация», «О компании».")
    @Severity(NORMAL)
    @Test
    public void Test() {
        getTitleLogo().should(Condition.visible);
        checkField(giveTitleText(), TITLE_HOME_PAGE);
        checkVisibility(getTitleLogo());
        goToSomeButton(getInfoButton());
        getReadyToFlyButton().shouldBe(Condition.visible);
        checkField(giveText(getReadyToFlyButton()), NAME_READY_TO_FLY_BUTTON);
        checkField(giveText(getGoodInfoButton()), NAME_GOOD_INFO_BUTTON);
        checkField(giveText(getAboutCompanyButton()), NAME_ABOUT_COMPANY_BUTTON);
    }

    @DisplayName("Тест №2")
    @Description(value = " " +
            "    1. Перейти на сайт pobeda.aero.\n" +
            "    2. Убедиться, что сайт открылся:\n" +
            "    а) текст заголовка страницы: Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, " +
            "прямые и трансферные рейсы;\n" +
            "    б) на странице есть логотип Победы.\n" +
            "    3. Проскроллить страницу к блоку поиска билета и убедиться, что блок с поиском билета действительно\n" +
            "     отображается (есть поле Откуда, Куда, Дата вылета Туда, Дата вылета Обратно)\n" +
            "    4. Выбрать (или ввести) следующие критерии поиска:\n" +
            "    откуда – Москва (без выбора аэропорта) + нажать Enter\n" +
            "    куда – Санкт-Петербург + нажать Enter.\n" +
            "    6. Нажать кнопку «Поиск».\n" +
            "    7. Убедиться, что около поля «Туда» появилась красная обводка.")
    @Severity(NORMAL)
    @Test
    public void PobedaTaskTest_2() {
        getTitleLogo().should(Condition.visible);
        checkField(giveTitleText(), TITLE_HOME_PAGE);
        checkVisibility(getTitleLogo());
        scrollTo(getTicketsBox());
        checkVisibility(getTicketFieldFrom());
        checkField(getNameTicketsField(getTicketFieldFrom(), TICKET_FIELD_NAME_ATTRIBUTE),
                NAME_TICKET_FIELD_FROM);
        checkVisibility(getTicketFieldTo());
        checkField(getNameTicketsField(getTicketFieldTo(), TICKET_FIELD_NAME_ATTRIBUTE),
                NAME_TICKET_FIELD_TO);
        checkVisibility(getTicketFieldDateIn());
        checkField(getNameTicketsField(getTicketFieldDateIn(), TICKET_FIELD_NAME_ATTRIBUTE),
                NAME_TICKET_FIELD_DATE_IN);
        checkVisibility(getTicketFieldDateBack());
        checkField(getNameTicketsField(getTicketFieldDateBack(), TICKET_FIELD_NAME_ATTRIBUTE),
                NAME_TICKET_FIELD_DATE_BACK);
        sendKeys(getTicketFieldFrom(), TEST_NAME_CITY_FROM);
        clickElement(getFirstElementInField());
        sendKeys(getTicketFieldTo(), TEST_NAME_CITY_TO);
        clickElement(getFirstElementInField());
        clickElement(getFindTicketsButton());
        checkField(giveColorOf(getTicketFieldDateInFrame()), RED_COLOR_FRAME_CODE);
    }

    @DisplayName("Тест №3")
    @Description(value = "   " +
            "    1. Перейти на сайт pobeda.aero.\n" +
            "    2. Убедиться, что сайт открылся:\n" +
            "    а) текст заголовка страницы: Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые " +
            "и трансферные рейсы;\n" +
            "    б) на странице есть логотип Победы.\n" +
            "    3. Проскроллить страницу чуть ниже и кликнуть на пункт «Управление бронированием».\n" +
            "    4. Убедиться, что открылась необходимая страница:\n" +
            "    а) есть поле «Номер заказа или билета»;\n" +
            "    б) есть поле «Фамилия клиента»;\n" +
            "    в) есть кнопка «Поиск».\n" +
            "    5. Ввести в поля ввода данные:\n" +
            "    номер заказа – XXXXXX, фамилия – Qwerty\n" +
            "    и нажать кнопку «Поиск».\n" +
            "    6. Убедиться, что в новой вкладке на экране отображается текст ошибки «Заказ с указанными параметрами не найден»")
    @Severity(NORMAL)
    @Test
    public void PobedaTaskTest_3() {
        PobedaBookingManagementPage PbmPage = new PobedaBookingManagementPage();
        PobedaSearchOrderPage PsoPage = new PobedaSearchOrderPage();
        getTitleLogo().should(Condition.visible);
        checkField(giveTitleText(), TITLE_HOME_PAGE);
        checkVisibility(getTitleLogo());
        // Так как на экране "Управление бронированием" закрыто рекламой, то нужно прокрутить ниже в конец страницы.
        scrollTo(getDownToPage());
        clickElement(getManageYourBooking());
        PbmPage.getSearchButton().shouldBe(Condition.interactable);
        checkVisibility(PbmPage.getLastNameField());
        checkVisibility(PbmPage.getTicketNumberField());
        checkVisibility(PbmPage.getSearchButton());
        sendKeys(PbmPage.getLastNameField(), TEST_LAST_NAME);
        sendKeys(PbmPage.getTicketNumberField(), TEST_TICKET_NUMBER);
        clickElement(PbmPage.getSearchButton());
        PsoPage.goToNextTab(1);
        PsoPage.getErrorMessage().shouldBe(Condition.visible);
        checkField(giveText(PsoPage.getErrorMessage()), SEARCH_ORDER_PAGE_ERROR_MESSAGE);
    }
}