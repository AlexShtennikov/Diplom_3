package ru.yandex.praktikum.diplom3;

import api.UserApiClient;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class ForgotPasswordPageTest {

    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp() {

        Configuration.browserSize = "1920x1080";
        forgotPasswordPage =
                open("https://stellarburgers.nomoreparties.site/forgot-password",
                        ForgotPasswordPage.class);
    }


    @Test
    @DisplayName("Проверка перехода на страницу входа по кнопке 'Войти' на форме восстановления пароля" )
    public void clickEnterButtonShouldReturnLoginPage(){
        forgotPasswordPage.clickEnterButton();
        String expected = "https://stellarburgers.nomoreparties.site/login";
        String actual = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(actual, expected);
    }

}