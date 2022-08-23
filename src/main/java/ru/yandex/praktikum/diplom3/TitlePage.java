package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TitlePage {

    //Кнопка личный кабинет
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Личный Кабинет')]")
    private SelenideElement personalAccountButton;

    //Кнопка конструктор
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Конструктор')]")
    private SelenideElement designerButton;

    //Кнопка StellarBurgers
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'AppHeader_header__logo__2D0X2')]")
    private SelenideElement stellarBurgersButton;

    //Кнопка войти в аккаунт
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;

    //Кнопка Булки
    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'tab_tab__1SPyG') and descendant::*[text()='Булки']]//span")
    private SelenideElement bunButton;

    //Кнопка Соусы
    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'tab_tab__1SPyG') and descendant::*[text()='Соусы']]//span")
    private SelenideElement sauceButton;

    //Кнопка Начинки
    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'tab_tab__1SPyG') and descendant::*[text()='Начинки']]//span")
    private SelenideElement fillingButton;

    public void clickFillingButton() {
        this.fillingButton.click();
    }

    public void clickSauceButton() {
        this.sauceButton.click();
    }

    public void clickBunButton() {
        this.bunButton.click();
    }

    public void clickPersonalAccountButton(){
        this.personalAccountButton.click();
    }

    public void clickDesignerButton(){
        this.designerButton.click();
    }

    public void clickStellarBurgersButton(){
        this.stellarBurgersButton.click();
    }

    public void clickEnterAccountButton() {
        this.enterAccountButton.click();
    }
}
