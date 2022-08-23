package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class TitlePageTest {

    TitlePage titlePage;

    @Before
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        titlePage =
                open("https://stellarburgers.nomoreparties.site/",
                        TitlePage.class);
    }

    @Test
    @DisplayName("Переход с титуальной страницы на страницу личный кабинет")
    public void clickPersonalAccountButtonShouldReturnCorrectUrl(){
        String expected = "https://stellarburgers.nomoreparties.site/login";
        titlePage.clickPersonalAccountButton();
        String actual = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Проверка перехода на страницу входа по кнопке 'Войти в аккаунт'")
    public void clickEnterAccountButtonShouldReturnLoginPage(){
        titlePage.clickEnterAccountButton();
        String expected = "https://stellarburgers.nomoreparties.site/login";
        String actual = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Переход со страницы личный кабинет на титульную страницу по кнопке конструктор")
    public void clickDesignerButtonShouldReturnCorrectUrl(){
        titlePage.clickPersonalAccountButton();
        String expected = "https://stellarburgers.nomoreparties.site/";
        titlePage.clickDesignerButton();
        String actual = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Переход со страницы личный кабинет на титульную страницу по кнопке stellar burgers")
    public void clickStellarBurgersButtonShouldReturnCorrectUrl(){
        titlePage.clickPersonalAccountButton();
        String expected = "https://stellarburgers.nomoreparties.site/";
        titlePage.clickStellarBurgersButton();
        String actual = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Проверка перехода по кнопке 'Булки'")
    public void clickBunButtonShouldMakeCorrectTransition(){
        //Сначала переходим на кнопку 'Соусы', чтобы кнопка 'Булки стала активна'
        titlePage.clickSauceButton();
        titlePage.clickBunButton();
        String actual = $("[class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect").getText();
        String expected = "Булки";
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Проверка перехода по кнопке 'Соусы'")
    public void clickSauceButtonShouldMakeCorrectTransition(){
        titlePage.clickSauceButton();
        String actual = $("[class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect").getText();
        String expected = "Соусы";
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Проверка перехода по кнопке 'Начинки'")
    public void clickFillingButtonShouldMakeCorrectTransition(){
        titlePage.clickFillingButton();
        String actual = $("[class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect").getText();
        String expected = "Начинки";
        assertEquals(actual, expected);
    }
}