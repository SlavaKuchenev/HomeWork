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
    By popupListSizeLabelLocator = By.xpath(".//li");
    By buttonToOkayCookiesLocator = By.xpath("//button[text()='Окей']");

    public void addToBasket(int[] numberProduct) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCardLocator));
        List<WebElement> productsButton = driver.findElements(buttonAddToBasketLocator);
        for (int i : numberProduct) {
            scrollToElement(driver,productsButton.get(i));
            wait.until(ExpectedConditions.visibilityOf(productsButton.get(i))).click();
            if (isPopupListSizeDisplayed()) {
                List<WebElement> listSizeLabel = driver.findElement(popupListSizeLocator).findElements(popupListSizeLabelLocator);
                int sizeLabelIndex = listSizeLabel.size()/2;
                listSizeLabel.get(sizeLabelIndex).click();
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
            boolean priceChange = true;
            scrollToElement(driver,productsPrice.get(i));
            while (priceChange) {
                int price = Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productsPrice.get(i))).getText().replaceAll("[₽\\s]", ""));
                if (price == Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productsPrice.get(i))).getText().replaceAll("[₽\\s]", ""))) {
                    priceChange = false;
                    productPriceList.add(Integer.parseInt(productsPrice.get(i).getText().replaceAll("[₽\\s]", "")));
                }
            }
        }
        return productPriceList;
    }

    public List<String> getProductName(int[] numberProduct) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCardLocator));
        List<WebElement> productsName = driver.findElements(productNameLocator);
        List<String> productName = new ArrayList<>();
        for (int i : numberProduct) {
            scrollToElement(driver,productsName.get(i));
            productName.add(productsName.get(i).getText().replaceAll("[OIMC./\\s]", ""));
        }
        return productName;
    }

    public WildberriesBaskedPage goToBasket() {
        scrollToElement(driver, driver.findElement(buttonToBasketLocator));
        driver.findElement(buttonToBasketLocator).click();
        return new WildberriesBaskedPage(driver);
    }

    public void clickButtonOkay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCardLocator));
        driver.findElement(buttonToOkayCookiesLocator).click();
    }
    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }
}
