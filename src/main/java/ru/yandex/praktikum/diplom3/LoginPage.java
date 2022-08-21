package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //Поле email
    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input")
    private SelenideElement fieldEmail;

    //Поле password
    @FindBy(how = How.XPATH, using = "//fieldset[2]/div/div/input")
    private SelenideElement fieldPassword;

    //Кнопка войти
    @FindBy(how = How.XPATH, using = "//form/button")
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
