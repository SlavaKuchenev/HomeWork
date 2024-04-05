package pageEntity;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Mts {
    @FindBy(xpath = "//div[@class='cookie__buttons']/button[@class='btn btn_black cookie__ok']")
    private WebElement cookiAceptMenu;
    @FindBy(xpath = "//div[@class='pay__wrapper']/h2[contains(text(),'Онлайн пополнение ')]")
    private WebElement blockTitle;
    @FindBy(xpath = "//form[@id='pay-connection']/descendant::input[@class='phone']")
    private WebElement phoneNumder;
    @FindBy(xpath = "//form[@id='pay-connection']/descendant::input[@class='total_rub']")
    private WebElement totalRub;
    @FindBy(xpath = "//form[@id='pay-connection']/descendant::button[contains(text(),'Продолжить')]")
    private WebElement buttonContinue;
    @FindBy(xpath = "//p[contains(text(),'Оплата:')]")
    private WebElement blockTitlePayment;
    @FindBy(xpath = "//ul[@class = 'select__list']//p")
    private List<WebElement> paymentSelectList;
    @FindBy(xpath = "//div[@class = 'select__wrapper']")
    private WebElement paymentSelectListButton;
    @FindBy(xpath = "//button[text()=' Оплатить  20.00 BYN ']")
    private WebElement buttonContinuePayment;
    @FindBy(xpath = "//button[text()=' Оплатить  20.00 BYN ']")
    private WebElement costOfPayment;
    @FindBy(xpath = "//div[@class= 'cards-brands ng-tns-c49-1']//img")
    private List<WebElement> cardsBrandsList;
    @FindBy(xpath = "//input[@placeholder='Номер абонента']")
    private WebElement subscriberNumber;
    @FindBy(xpath = "//input[@placeholder='Номер абонента']")
    private WebElement accountPhoneNumber;
    @FindBy(xpath = "//input[@placeholder='Номер абонента']")
    private WebElement accountNumberComb;
    @FindBy(xpath = "//input[@placeholder='Номер счета на 2073']")
    private WebElement accountNumberDebt;
    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement paymentAmount;
    @FindBy(xpath = "//input[@placeholder='E-mail для отправки чека']")
    private WebElement email;

    public void clickToCookieAcceptButton() {
        cookiAceptMenu.click();
    }

    public WebElement getBlockTitle() {
        return blockTitle;
    }

    public WebElement getPhoneNumder() {
        return phoneNumder;
    }

    public WebElement getTotalRub() {
        return totalRub;
    }

    public WebElement getButtonContinue() {
        return buttonContinue;
    }

    public void clickToButtonContinue() {
        buttonContinue.click();
    }

    public WebElement getBlockTitlePayment() {
        return blockTitlePayment;
    }

    public List<WebElement> getPaymentSelectList() {
        return paymentSelectList;
    }

    public WebElement getPaymentSelectListButton() {
        return paymentSelectListButton;
    }

    public WebElement getButtonContinuePayment() {
        return buttonContinuePayment;
    }

    public WebElement getCostOfPayment() {
        return costOfPayment;
    }

    public List<WebElement> getCardsBrandsList() {
        return cardsBrandsList;
    }

    public WebElement getSubscriberNumber() {
        return subscriberNumber;
    }

    public WebElement getAccountPhoneNumber() {
        return accountPhoneNumber;
    }

    public WebElement getAccountNumberComb() {
        return accountNumberComb;
    }

    public WebElement getAccountNumberDebt() {
        return accountNumberDebt;
    }

    public WebElement getPaymentAmount() {
        return paymentAmount;
    }

    public WebElement getEmail() {
        return email;
    }
}