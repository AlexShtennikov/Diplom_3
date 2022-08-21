package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    //Кнопка войти
    @FindBy(how = How.XPATH, using = "//div/div/p/a")
    private SelenideElement enterButton;

    public void clickEnterButton(){
        this.enterButton.click();
    }

}
