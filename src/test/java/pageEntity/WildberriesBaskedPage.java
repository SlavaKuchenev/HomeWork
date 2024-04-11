package pageEntity;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


public class WildberriesBaskedPage extends WildberriesPage {

    By numberProductLocator = By.xpath("//div[@class='list-item__good']");
    By numberOneProductLocator = By.xpath("//input[@type= 'number']");
    By productNameLocator = By.xpath("//div[@class='list-item__good']//span[@class='good-info__good-name']");
    By productPriceLocator = By.xpath("//div[@class='list-item__price-wallet']");
    By productPriceSumLocator = By.xpath("//span[@class= 'b-right']");
    By productPriceWithoutDiscountLocator = By.xpath("//div[@class= 'list-item__price-new wallet']");


    public WildberriesBaskedPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> numberProduct() {
        return driver.findElements(numberProductLocator);
    }

    public List<String> getProductName() {

        List<WebElement> productsName = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(productNameLocator)));
        List<String> productName = new ArrayList<>();
        for (WebElement element : productsName) {
            productName.add(element.getText().replaceAll("[OIMC/.\\s]", ""));
        }
        return productName;
    }

    public List<Integer> getProductPrice() {
        List<WebElement> productsPrice = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(productPriceLocator)));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(productsPrice.get(0), "formatMoneyAnim")));
        List<Integer> productPriceList = new ArrayList<>();
        for (WebElement element : productsPrice) {
            boolean priceChange = true;
            while (priceChange) {
                int price = Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(element)).getText().replaceAll("[₽\\s]", ""));
                if (price == Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(element)).getText().replaceAll("[₽\\s]", ""))) {
                    priceChange = false;
                    productPriceList.add(Integer.parseInt(element.getText().replaceAll("[₽\\s]", "")));
                }
            }
        }
        return productPriceList;
    }

    public int getProductPriceWithoutDiscountSum() {
        List<WebElement> productsPrice = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(productPriceWithoutDiscountLocator)));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(productsPrice.get(0), "formatMoneyAnim")));
        int productPrice = 0;
        for (WebElement element : productsPrice) {
            productPrice += Integer.parseInt(element.getText().replaceAll("[₽\\s]", ""));
        }
        return productPrice;
    }

    public int getProductPriceAll() {
        WebElement productsPrice = wait.until(ExpectedConditions.visibilityOf(driver.findElement(productPriceSumLocator)));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(productsPrice, "formatMoneyAnim")));
        return Integer.parseInt(productsPrice.getText().replaceAll("[₽\\s]", ""));
    }

    public List<Integer> numberOneProductLocator() {
        List<WebElement> numberOneProduct = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(numberOneProductLocator)));
        List<Integer> numberOneProductList = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement element : numberOneProduct) {
            String valueAsString = (String) js.executeScript("return arguments[0].value;", element);
            int value = Integer.parseInt(valueAsString);
            numberOneProductList.add(value);
        }
        return numberOneProductList;
    }
}
