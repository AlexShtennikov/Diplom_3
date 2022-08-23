package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class RegisterPage {

    //Поле имя
    @FindBy(how = How.XPATH, using = "//*[@class='input__container' and descendant::label[text()='Имя']]//input")
    private SelenideElement fieldName;

    //Поле email
    @FindBy(how = How.XPATH, using = "//*[@class='input__container' and descendant::label[text()='Email']]//input")
    private SelenideElement fieldEmail;

    //Поле пароль
    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private SelenideElement fieldPassword;

    //Кнопка зарегистрироваться
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    //Кнопка войти
    @FindBy(how = How.XPATH, using = "//*[@class='Auth_link__1fOlj']")
    private SelenideElement enterButton;

    public void clickRegisterButton(){
        this.registerButton.click();
    }

    public void clickEnterButton(){
        this.enterButton.click();
    }

    public void setName(String name){
        this.fieldName.setValue(name);
    }

    public void setEmail(String email){
        this.fieldEmail.setValue(email);
    }

    public void setPassword(String password){
        this.fieldPassword.setValue(password);
    }

}
