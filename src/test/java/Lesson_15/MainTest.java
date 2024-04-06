package Lesson_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageEntity.WildberriesBaskedPage;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    int[] numberProduct = {0,3,5};
    @BeforeEach
    void initPageObject() throws InterruptedException {

    }

    @Test
    public void testAddingToCartAndChecking() throws InterruptedException {
        wildberriesPage.addToBasket(numberProduct);
        List<String> productsName = wildberriesPage.getProductName(numberProduct);
        List<String> productsPrice = wildberriesPage.getProductPrice(numberProduct);
        WildberriesBaskedPage wildberriesBaskedPage = wildberriesPage.goToBasket();
        assertEquals(wildberriesBaskedPage.numberProduct().size(), numberProduct.length);
        assertEquals(productsName,wildberriesBaskedPage.getProductName());
        Thread.sleep(20000);
    }
}
