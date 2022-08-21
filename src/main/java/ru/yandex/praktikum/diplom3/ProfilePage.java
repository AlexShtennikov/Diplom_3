package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    //Кнопка выйти
    @FindBy(how = How.XPATH, using = "//ul/li[3]/button")
    private SelenideElement exitButton;

    public void clickExitButton(){
        this.exitButton.click();
    }

}
