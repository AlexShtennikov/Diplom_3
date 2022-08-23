package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //Поле email
    @FindBy(how = How.XPATH, using = "//*[@class='input__container' and descendant::label[text()='Email']]//input")
    private SelenideElement fieldEmail;

    //Поле password
    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private SelenideElement fieldPassword;

    //Кнопка войти
    @FindBy(how = How.XPATH, using = "//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement enterButton;

    public void clickEnterButton(){
        this.enterButton.click();
    }

    public void setFieldEmail(String fieldEmail) {
        this.fieldEmail.setValue(fieldEmail);
    }

    public void setFieldPassword(String fieldPassword) {
        this.fieldPassword.setValue(fieldPassword);
    }
}
