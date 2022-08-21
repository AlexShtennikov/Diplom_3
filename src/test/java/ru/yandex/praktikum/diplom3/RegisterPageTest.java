package ru.yandex.praktikum.diplom3;

import api.User;
import api.UserApiClient;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class RegisterPageTest {
    private String name;
    private String email;
    private String password;
    private RegisterPage registerPage;
    private UserApiClient userClient;

    @Before
    public void setUp() {
        userClient = new UserApiClient();

        Faker faker = new Faker();

        name = faker.name().name();
        email = faker.internet().emailAddress();
        password = faker.internet().password(7, 10);

        Configuration.browserSize = "1920x1080";
        registerPage =
                open("https://stellarburgers.nomoreparties.site/register",
                        RegisterPage.class);
    }

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    public void tryRegisterWithCorrectDateShouldReturnNewUser() throws InterruptedException{

        registerPage.setName(name);
        registerPage.setEmail(email);
        registerPage.setPassword(password);

        registerPage.clickRegisterButton();
        Thread.sleep(1000);
        String expected = "https://stellarburgers.nomoreparties.site/login";
        String actual = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertEquals(actual, expected);
        endSession();
    }

    @Test
    @DisplayName("Проверка перехода на страницу входа по кнопке 'Войти' на форме регистрации")
    public void clickEnterButtonShouldReturnLoginPage(){
        registerPage.clickEnterButton();
        String expected = "https://stellarburgers.nomoreparties.site/login";
        String actual = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(actual, expected);
    }

    //Вспомогательные методы
    public void endSession() {

       User user = new User(email, password, name);
       String accessToken = userClient.loginUser(user)
                .then()
                .statusCode(200)
                .extract().body().path("accessToken");

       String correctAccessToken = accessToken.replace("Bearer ", "");
       userClient.deleteUser(correctAccessToken);
    }

}
