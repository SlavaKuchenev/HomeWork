package Lesson_15;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pageEntity.WildberriesBaskedPage;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {
    private static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 3, 5}},
                {new int[]{1, 2, 4}},
        });
    }


    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("Проверка добовления товара в корзину")
    public void testAddingToCartAndChecking(int[] numberProduct) {
        wildberriesPage.clickButtonOkay();
        wildberriesPage.addToBasket(numberProduct);
        List<String> productsName = wildberriesPage.getProductName(numberProduct);
        List<Integer> productPriceList = wildberriesPage.getProductPriceSum(numberProduct);
        WildberriesBaskedPage wildberriesBaskedPage = wildberriesPage.goToBasket();
        List<String> productsNameBasket = wildberriesBaskedPage.getProductName();
        Collections.sort(productsName);
        Collections.sort(productsNameBasket);
        assertEquals(wildberriesBaskedPage.numberProduct().size(), numberProduct.length);
        assertEquals(productsName, productsNameBasket);
        List<Integer> productPriceBaskedList = wildberriesBaskedPage.getProductPrice();
        Collections.sort(productPriceList);
        Collections.sort(productPriceBaskedList);
        assertEquals(productPriceList, productPriceBaskedList);
        assertEquals(wildberriesBaskedPage.getProductPriceWithoutDiscountSum(), wildberriesBaskedPage.getProductPriceAll());
        for (int i : wildberriesBaskedPage.numberOneProductLocator()) {
            assertEquals(1, i);
        }
    }
}
