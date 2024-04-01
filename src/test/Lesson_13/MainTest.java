package Lesson_13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageEntity.Mts;

import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    Mts mts;
    WebDriverWait wait;

    @BeforeEach
    void initPageObject() {
        mts = PageFactory.initElements(driver, Mts.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        open();
    }

    public void open() {
        driver.get("https://www.mts.by/");
        mts.clickToCookieAcceptButton();
    }

    @Test
    public void testBlockTitle() {
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getBlockTitle())).isDisplayed(), "Название  блока отсуствует");
        assertEquals("Онлайн пополнение\nбез комиссии", mts.getBlockTitle().getText(), "Название  блока не корректно");
    }

    @Test
    public void testPaymentSystemLogos() {
        assertTrue(mts.getPaymentSystemLogos().size() > 0, "Логотипы платёжных систем отсуствуют");
        for (WebElement logo : mts.getPaymentSystemLogos()) {
            assertTrue(logo.isDisplayed(), "Логотип отсуствует");
        }
    }

    @Test
    public void testServiceDetailsLink() {
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getServiceDetailsLink())).isDisplayed(), "Название  блока отсуствует");
        mts.clickServiceDetailsLink();
        assertEquals(driver.getCurrentUrl(), "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
    }

    @Test
    public void testContinueButtonForMobileServices() {
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getButtonContinue())).isDisplayed(), "Название  блока отсуствует");
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getPhoneNumder())).isDisplayed(), "Название  блока отсуствует");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mts.getBlockTitle());
        mts.getPhoneNumder().click();
        mts.getPhoneNumder().sendKeys("297777777");
        mts.getTotalRub().click();
        mts.getTotalRub().sendKeys("20");
        mts.clickToButtonContinue();
        WebElement element1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"))));
        driver.switchTo().frame(element1);
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getBlockTitlePayment())).isDisplayed());
    }
}
