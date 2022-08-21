package ru.yandex.praktikum.diplom3;

import api.User;
import api.UserApiClient;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class LoginPageTest {

    private String accessToken;
    private String name;
    private String email;
    private String password;
    private LoginPage loginPage;
    private UserApiClient userClient;

    @Before
    public void setUp() {
        userClient = new UserApiClient();

        Faker faker = new Faker();

        name = faker.name().name();
        email = faker.internet().emailAddress();
        password = faker.internet().password(7, 10);

        Configuration.browserSize = "1920x1080";
        loginPage =
                open("https://stellarburgers.nomoreparties.site/login",
                        LoginPage.class);
    }

    @After
    public void endSession() {

        User user = new User(email, password, name);
        accessToken = userClient.loginUser(user)
                .then()
                .statusCode(200)
                .extract().body().path("accessToken");

        String correctAccessToken = accessToken.replace("Bearer ", "");
        userClient.deleteUser(correctAccessToken);
    }

    @Test
    @DisplayName("Вход под существующим пользователем")
    public void tryRegisterWithCorrectDateShouldReturnNewUser() throws InterruptedException{

        User user = new User(email, password, name);
        accessToken = userClient.createUser(user)
                .then()
                .statusCode(200)
                .extract().body().path("accessToken");

        loginPage.setFieldEmail(email);
        loginPage.setFieldPassword(password);

        loginPage.clickEnterButton();
        Thread.sleep(1000);
        String expected = "https://stellarburgers.nomoreparties.site/";
        String actual = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertEquals(actual, expected);
    }

}