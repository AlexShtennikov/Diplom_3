package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class RegisterPage {

    //Поле имя
    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input")
    private SelenideElement fieldName;

    //Поле email
    @FindBy(how = How.XPATH, using = "//fieldset[2]/div/div/input")
    private SelenideElement fieldEmail;

    //Поле пароль
    @FindBy(how = How.XPATH, using = "//fieldset[3]/div/div/input")
    private SelenideElement fieldPassword;

    //Кнопка зарегистрироваться
    @FindBy(how = How.XPATH, using = "//form/button")
    private SelenideElement registerButton;

    //Кнопка войти
    @FindBy(how = How.XPATH, using = "//div/div/p/a")
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
