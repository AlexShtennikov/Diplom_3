package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    //Кнопка выйти
    @FindBy(how = How.XPATH, using = "//*[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement exitButton;

    public void clickExitButton(){
        this.exitButton.click();
    }

}
