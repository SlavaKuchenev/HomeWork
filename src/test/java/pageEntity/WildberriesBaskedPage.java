package pageEntity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class WildberriesBaskedPage extends WildberriesPage {

    By numberProductLocator= By.xpath("//div[@class='list-item__good']");
    public WildberriesBaskedPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> numberProduct(){
        return driver.findElements(numberProductLocator);
    }

}
