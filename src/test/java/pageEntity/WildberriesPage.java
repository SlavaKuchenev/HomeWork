package pageEntity;

import org.openqa.selenium.By;

public class WildberriesPage {


    private By productCard;

    public By getProductCard(String pattern) {
        return productCard= By.xpath(String.format("//div[@class='product-card__wrapper']%s", pattern));
    }
}
