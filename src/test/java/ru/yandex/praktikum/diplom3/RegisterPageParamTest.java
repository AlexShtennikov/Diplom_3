package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RegisterPageParamTest {

    String name;
    String email;
    String password;

    public RegisterPageParamTest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] tryRegisterWithIncorrectPassword() {

        Faker faker = new Faker();

        return new Object[][] {
                {faker.name().name(), faker.internet().emailAddress(), faker.internet().password(1, 2)},
                {faker.name().name(), faker.internet().emailAddress(), faker.internet().password(4, 5)},
        };
    }

    RegisterPage registerPage;

    @Before
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        registerPage =
                open("https://stellarburgers.nomoreparties.site/register",
                        RegisterPage.class);
    }

    @Test
    @DisplayName("Попытка регистрации с некорректным паролем")
    public void tryRegisterWithIncorrectPasswordShouldReturnError() {

        registerPage.setName(name);
        registerPage.setEmail(email);
        registerPage.setPassword(password);

        registerPage.clickRegisterButton();

        String actual = $("[class='input__error text_type_main-default").getText();
        String expected = "Некорректный пароль";
        assertEquals(actual, expected);
    }

}
