package pageEntity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class WildberriesBaskedPage extends WildberriesPage {

    By numberProductLocator= By.xpath("//div[@class='list-item__good']");
    By productNameLocator= By.xpath("//div[@class='list-item__good']//span[@class='good-info__good-name']");
    By productPriceLocator= By.xpath("//div[@class='list-item__price-wallet']");


    public WildberriesBaskedPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> numberProduct(){
        return driver.findElements(numberProductLocator);
    }
    public List<String> getProductName() {

        List<WebElement> productsName = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(productNameLocator)));
        List<String> productName= new ArrayList<>();
        for (WebElement element : productsName) {
            productName.add(element.getText());
        }
        return productName;
    }

    public List<String> getProductPrice(int[] numberProduct) {
        List<WebElement> productsPrice = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(productPriceLocator)));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(productsPrice.get(0), "formatMoneyAnim")));
        List<String> productPrice= new ArrayList<>();
        for (int i : numberProduct) {
            productPrice.add(productsPrice.get(i).getText().replaceAll("₽", ""));
        }
        return productPrice;
    }
}
