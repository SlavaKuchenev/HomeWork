package pageEntity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class WildberriesPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WildberriesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    By productCardLocator = By.xpath("//div[@class='product-card__wrapper']");
    By buttonAddToBasketLocator = By.xpath("//div[@class='product-card__wrapper']//a[@class='product-card__add-basket j-add-to-basket btn-main']");
    By buttonToBasketLocator = By.xpath("//div[@class='navbar-pc__item j-item-basket']/a");
    By productNameLocator = By.xpath("//div[@class='product-card__wrapper']//span[@class='product-card__name']");
    By productPriceLocator = By.xpath("//div[@class='product-card__wrapper']//ins");
    By popupListSizeLocator = By.xpath("//div[@class='popup popup-list-of-sizes shown slideUp']");
    By popupListSizeLabelLocator = By.xpath("//li");

    public void addToBasket(int[] numberProduct) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCardLocator));
        List<WebElement> productsButton = driver.findElements(buttonAddToBasketLocator);
        for (int i : numberProduct) {
            wait.until(ExpectedConditions.visibilityOf(productsButton.get(i))).click();
            if (isPopupListSizeDisplayed()) {
                driver.findElement(popupListSizeLocator).findElements(popupListSizeLabelLocator).get(0).click();
            }
        }
    }

    private boolean isPopupListSizeDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(popupListSizeLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Integer> getProductPriceSum(int[] numberProduct) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCardLocator));
        List<WebElement> productsPrice = driver.findElements(productPriceLocator);
        List<Integer> productPriceList = new ArrayList<>();
        for (int i : numberProduct) {
            productPriceList.add(Integer.parseInt(productsPrice.get(i).getText().replaceAll("[₽\\s]", "")));
        }
        return productPriceList;
    }

    public List<String> getProductName(int[] numberProduct) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCardLocator));
        List<WebElement> productsName = driver.findElements(productNameLocator);
        List<String> productName = new ArrayList<>();
        for (int i : numberProduct) {
            productName.add(productsName.get(i).getText().replaceAll("[./\\s]", ""));
        }
        return productName;
    }

    public WildberriesBaskedPage goToBasket() {
        driver.findElement(buttonToBasketLocator).click();
        return new WildberriesBaskedPage(driver);
    }
}
