package Lesson_15;


import org.junit.jupiter.api.Test;
import pageEntity.WildberriesBaskedPage;


import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {

    @Test
    public void testAddingToCartAndChecking() throws InterruptedException {
        int[] numberProduct = {0, 3, 5};
        wildberriesPage.addToBasket(numberProduct);
        List<String> productsName = wildberriesPage.getProductName(numberProduct);
        int productPriceSum = wildberriesPage.getProductPriceSum(numberProduct);
        WildberriesBaskedPage wildberriesBaskedPage = wildberriesPage.goToBasket();
        List<String> productsNameBasket = wildberriesBaskedPage.getProductName();
        Collections.sort(productsName);
        Collections.sort(productsNameBasket);
        assertEquals(wildberriesBaskedPage.numberProduct().size(), numberProduct.length);
        Thread.sleep(3000);
        assertEquals(productsName, productsNameBasket);
        assertEquals(productPriceSum, wildberriesBaskedPage.getProductPriceSum());
        assertEquals(wildberriesBaskedPage.getProductPriceWithoutDiscountSum(), wildberriesBaskedPage.getProductPriceAll());
        for (int i : wildberriesBaskedPage.numberOneProductLocator()) {
            assertEquals(1, i);
        }
    }
}
