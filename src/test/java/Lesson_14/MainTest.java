package Lesson_14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageEntity.Mts;

import java.time.Duration;
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

    public void openPaymentContainer() {
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getButtonContinue())).isDisplayed(), "Название  блока отсуствует");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mts.getBlockTitle());
        mts.getPhoneNumder().sendKeys("297777777");
        mts.getTotalRub().sendKeys("20");
        mts.clickToButtonContinue();
        WebElement element1 = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(element1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"})
    @DisplayName("Наличие лейблов")
    public void testEmptyFieldLabels(String desiredName) {
        mts.getPaymentSelectListButton().click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);", mts.getBlockTitle());
        wait.until(ExpectedConditions.visibilityOfAllElements(mts.getPaymentSelectList()));
        for (WebElement element : mts.getPaymentSelectList()) {
            if (element.getAttribute("innerHTML") == desiredName) {
                element.click();
                assertTrue(mts.getAccountPhoneNumber().isDisplayed());
                assertTrue(mts.getEmail().isDisplayed());
                assertTrue(mts.getPaymentAmount().isDisplayed());
            }
            if (element.getAttribute("innerHTML") == desiredName) {
                element.click();
                assertTrue(mts.getSubscriberNumber().isDisplayed());
                assertTrue(mts.getEmail().isDisplayed());
                assertTrue(mts.getPaymentAmount().isDisplayed());
            }
            if (element.getAttribute("innerHTML") == desiredName) {
                element.click();
                assertTrue(mts.getAccountNumberComb().isDisplayed());
                assertTrue(mts.getEmail().isDisplayed());
                assertTrue(mts.getPaymentAmount().isDisplayed());
            }
            if (element.getAttribute("innerHTML") == desiredName) {
                element.click();
                assertTrue(mts.getAccountNumberDebt().isDisplayed());
                assertTrue(mts.getEmail().isDisplayed());
                assertTrue(mts.getPaymentAmount().isDisplayed());
            }

        }
    }


    List<String> expectedOptionsCardName = Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)");

    @Test
    @DisplayName("Наличие надписи в незаполненных полях")
    public void testContinueBMobileServices() {
        openPaymentContainer();
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getBlockTitlePayment())).isDisplayed());
        for (String expectedOption : expectedOptionsCardName) {
            WebElement optionElement = driver.findElement(By.xpath("//label[text()='" + expectedOption + "']"));
            assertTrue(optionElement.isDisplayed());
        }
    }

    @Test
    @DisplayName("Наличие лейблов")
    public void testCardsBrandsLogo() {
        openPaymentContainer();
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getBlockTitlePayment())).isDisplayed());
        assertTrue(mts.getCardsBrandsList().size() > 0, "Логотипы платёжных систем отсуствуют");
        for (WebElement logo : mts.getCardsBrandsList()) {
            assertTrue(wait.until(ExpectedConditions.visibilityOf(logo)).isDisplayed(), "Логотип отсуствует");
        }
    }

    @Test
    public void testCostAndNumber() {
        openPaymentContainer();
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getBlockTitlePayment())).isDisplayed());
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getButtonContinuePayment())).isDisplayed());
        assertTrue(wait.until(ExpectedConditions.visibilityOf(mts.getCostOfPayment())).isDisplayed());
        assertEquals(mts.getBlockTitlePayment().getText(), "Оплата: Услуги связи Номер:375297777777");
    }
}