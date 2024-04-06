package pageEntity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WildberriesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public WildberriesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }


    By productCard = By.xpath("//div[@class='product-card__wrapper']");

    By buttonAddToCart = By.xpath("//div[@class='product-card__wrapper']//a[@class='product-card__add-basket j-add-to-basket btn-main']");
    By productName = By.xpath("//div[@class='product-card__wrapper']//span[@class='product-card__name']");
    By productPrice = By.xpath("//div[@class='product-card__wrapper']//ins");

    By popupListSize = By.xpath("//div[@class='popup popup-list-of-sizes shown slideUp']");

    By popupListSizeLabel = By.xpath("//li");

    public void addToCart(int[] numberProduct) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCard));
        List<WebElement> productsButton = driver.findElements(buttonAddToCart);
        for (int i : numberProduct) {
            productsButton.get(i).click();
            if (isPopupListSizeDisplayed()) {
                driver.findElement(popupListSize).findElements(popupListSizeLabel).get(0).click();
            }
        }
    }

    private boolean isPopupListSizeDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(popupListSize));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<String> getProductPrice(int[] numberProduct) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCard));
        List<WebElement> productsPrice = driver.findElements(productPrice);
        List<String> productPrice= new ArrayList<>();
        for (int i : numberProduct) {
            productPrice.add(productsPrice.get(i).getText());
        }
        return productPrice;
    }

    public List<String> getProductName(int[] numberProduct) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCard));
        List<WebElement> productsName = driver.findElements(productName);
        List<String> productName= new ArrayList<>();
        for (int i : numberProduct) {
            productName.add(productsName.get(i).getText());
        }
        return productName;
    }

}
/*public void getProductPrice(int[] randomNumberProduct) {
        productCard.get(randomNumberProduct[0]).findElement(By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']")).click();
        productCard.get(randomNumberProduct[1]).findElement(By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']")).click();
        productCard.get(randomNumberProduct[2]).findElement(By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']")).click();
    }

    public void goToCart() {
        // Реализация перехода в корзину
    }

    public boolean isProductInCart(String productName) {
        // Реализация проверки наличия товара в корзине
        return false;
    }

    public int getProductQuantityInCart(String productName) {
        // Реализация получения количества товара в корзине
        return 0;
    }

    public int getProductPriceInCart(String productName) {
        // Реализация получения цены товара в корзине
        return 0;
    }

    public int getTotalPriceInCart() {
        // Реализация получения общей суммы товаров в корзине
        return 0;
    }*/