package Lesson_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageEntity.WildberriesBaskedPage;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    @BeforeEach
    void initPageObject() throws InterruptedException {

    }

    @Test
    public void testAddingToCartAndChecking() throws InterruptedException {
        int[] numberProduct = {0,3,5};
        wildberriesPage.addToBasket(numberProduct);
        List<String> productsName = wildberriesPage.getProductName(numberProduct);
        int productPriceSum = wildberriesPage.getProductPriceSum(numberProduct);
        WildberriesBaskedPage wildberriesBaskedPage = wildberriesPage.goToBasket();
        assertEquals(wildberriesBaskedPage.numberProduct().size(), numberProduct.length);
        assertEquals(productsName,wildberriesBaskedPage.getProductName());
        assertEquals(productPriceSum, wildberriesBaskedPage.getProductPriceSum());
        assertEquals(wildberriesBaskedPage.getProductPriceSum(), wildberriesBaskedPage.getProductPriceAll());

        Thread.sleep(20000);
    }
}
