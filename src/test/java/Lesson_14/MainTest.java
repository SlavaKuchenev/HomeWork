package Lesson_14;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void openPaymentContainer(){
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getButtonContinue())).isDisplayed(), "Название  блока отсуствует");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mts.getBlockTitle());
        mts.getPhoneNumder().click();
        mts.getPhoneNumder().sendKeys("297777777");
        mts.getTotalRub().click();
        mts.getTotalRub().sendKeys("20");
        mts.clickToButtonContinue();
        WebElement element1 = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(element1);
    }


    List<String> expectedOptions = Arrays.asList("Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность");

    @Test
    public void testEmptyFieldLabels() {
        mts.getPaymentSelectListButton().click();
        List<String> actualOptions = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfAllElements(mts.getPaymentSelectList()));
        for (WebElement element : mts.getPaymentSelectList()) {
            assertTrue(element.isDisplayed());
            actualOptions.add(element.getAttribute("innerHTML"));
        }
        assertEquals(expectedOptions, actualOptions);
    }

    List<String> expectedOptionsCardName = Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)");

    @Test
    public void testContinueBMobileServices() {
        openPaymentContainer();
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getBlockTitlePayment())).isDisplayed());
        for (String expectedOption : expectedOptionsCardName){
        WebElement optionElement = driver.findElement(By.xpath("//label[text()='" + expectedOption + "']"));
        assertTrue(optionElement.isDisplayed());
        }
    }

    @Test
    public void testCardsBrandsLogo(){
        openPaymentContainer();
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getBlockTitlePayment())).isDisplayed());
        assertTrue(mts.getCardsBrandsList().size() > 0, "Логотипы платёжных систем отсуствуют");
        for (WebElement logo : mts.getCardsBrandsList()) {
            assertTrue(wait.until(ExpectedConditions.visibilityOf(logo)).isDisplayed(), "Логотип отсуствует");
        }
    }

    @Test
    public void testCostAndNumber(){
        openPaymentContainer();
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getBlockTitlePayment())).isDisplayed());
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getButtonContinuePayment())).isDisplayed());
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getCostOfPayment())).isDisplayed());
        assertEquals(mts.getBlockTitlePayment().getText(),"Оплата: Услуги связи Номер:375297777777");
    }
}

