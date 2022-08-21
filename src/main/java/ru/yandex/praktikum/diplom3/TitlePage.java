package ru.yandex.praktikum.diplom3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TitlePage {

    //Кнопка личный кабинет
    @FindBy(how = How.XPATH, using = "//nav/a")
    private SelenideElement personalAccountButton;

    //Кнопка конструктор
    @FindBy(how = How.XPATH, using = "//nav/ul/li[1]/a")
    private SelenideElement designerButton;

    //Кнопка StellarBurgers
    @FindBy(how = How.XPATH, using = "//nav/div")
    private SelenideElement stellarBurgersButton;

    //Кнопка войти в аккаунт
    @FindBy(how = How.XPATH, using = "//section[2]/div/button")
    private SelenideElement enterAccountButton;

    //Кнопка Булки)
    @FindBy(how = How.XPATH, using = "//section[1]/div[1]")
    private SelenideElement bunButton;

    //Меню Булки)
    @FindBy(how = How.XPATH, using = "//section[1]/div[2]/h2[1]")
    public SelenideElement bunMenu;

    //Кнопка Соусы
    @FindBy(how = How.XPATH, using = "//section[1]/div[1]/div[2]")
    private SelenideElement sauceButton;

    //Меню Соусы
    @FindBy(how = How.XPATH, using = "//section[1]/div[2]/h2[2]")
    public SelenideElement sauceMenu;

    //Кнопка Начинки
    @FindBy(how = How.XPATH, using = "//section[1]/div[1]/div[3]")
    private SelenideElement fillingButton;

    //Меню Начинки
    @FindBy(how = How.XPATH, using = "//section[1]/div[2]/h2[3]")
    public SelenideElement fillingMenu;

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
