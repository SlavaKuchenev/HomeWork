package pageEntity;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Mts {


    @FindBy(xpath = "//div[@class='cookie__buttons']/button[@class='btn btn_black cookie__ok']")
    private WebElement cookiAceptMenu;
    @FindBy(xpath = "//a[contains(text(),'Подробнее о сервисе')]")
    private WebElement serviceDetailsLink;
    @FindBy(xpath = "//div[@class='pay__wrapper']/h2[contains(text(),'Онлайн пополнение ')]")
    private WebElement blockTitle;
    @FindBy(xpath = "//form[@id='pay-connection']/descendant::input[@class='phone']")
    private WebElement phoneNumder;
    @FindBy(xpath = "//form[@id='pay-connection']/descendant::input[@class='total_rub']")
    private WebElement totalRub;
    @FindBy(xpath = "//form[@id='pay-connection']/descendant::button[contains(text(),'Продолжить')]")
    private WebElement buttonContinue;
    @FindBy(xpath = "//div[@class='pay__partners']/descendant::img[starts-with(@src,'/local')]")
    private List<WebElement> paymentSystemLogos;
    @FindBy(xpath = "//p[contains(text(),'Оплата:')]")
    private WebElement blockTitlePayment;

    
    public List<WebElement> getPaymentSystemLogos() {
        return paymentSystemLogos;
    }

    public void clickToCookieAcceptButton() {
        cookiAceptMenu.click();
    }

    public void clickServiceDetailsLink() {
        serviceDetailsLink.click();
    }

    public WebElement getBlockTitle() {
        return blockTitle;
    }

    public WebElement getServiceDetailsLink() {
        return serviceDetailsLink;
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
}
