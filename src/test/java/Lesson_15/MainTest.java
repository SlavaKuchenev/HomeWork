package Lesson_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    int[] numberProduct = {0,3,5};
    @BeforeEach
    void initPageObject() throws InterruptedException {

    }

    @Test
    public void testAddingToCartAndChecking() throws InterruptedException {
        wildberriesPage.addToCart(numberProduct);
        List<String> productsName = wildberriesPage.getProductName(numberProduct);
        List<String> productsPrice = wildberriesPage.getProductPrice(numberProduct);
        Thread.sleep(20000);
    }
}
