package ru.yandex.praktikum.diplom3;

import api.User;
import api.UserApiClient;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.Assert.*;

public class LoginPageTest {

    private String accessToken;
    private String name;
    private String email;
    private String password;
    private LoginPage loginPage;
    private UserApiClient userClient;
    private User user;

    @Before
    public void setUp() {
        userClient = new UserApiClient();

        Faker faker = new Faker();

        name = faker.name().name();
        email = faker.internet().emailAddress();
        password = faker.internet().password(7, 10);

        user = new User(email, password, name);

        Configuration.browserSize = "1920x1080";
        loginPage =
                open("https://stellarburgers.nomoreparties.site/login",
                        LoginPage.class);
    }

    @After
    public void endSession() {

        accessToken = userClient.loginUser(user)
                .then()
                .statusCode(HTTP_OK)
                .extract().body().path("accessToken");

        String correctAccessToken = user.getCorrectAccessToken(accessToken);
        userClient.deleteUser(correctAccessToken);
    }

    @Test
    @DisplayName("Вход под существующим пользователем")
    public void tryRegisterWithCorrectDateShouldReturnNewUser(){

        accessToken = userClient.createUser(user)
                .then()
                .statusCode(HTTP_OK)
                .extract().body().path("accessToken");

        loginPage.setFieldEmail(email);
        loginPage.setFieldPassword(password);

        loginPage.clickEnterButton();

        webdriver().shouldHave(currentFrameUrl("https://stellarburgers.nomoreparties.site/"));
        String expected = "https://stellarburgers.nomoreparties.site/";
        String actual = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertEquals(actual, expected);
    }

}