package Lesson_15;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pageEntity.WildberriesBaskedPage;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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
                {new int[]{6, 11, 9}},
                {new int[]{21, 2, 13}},
                {new int[]{1, 2, 4}},
        });
    }

    public static void hideBanners() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        String script = "function hideBanners() { " +
                "var banners = document.querySelectorAll('.banner');" +
                "banners.forEach(function(banner) { " +
                "banner.style.display = 'none'; });}";

        try {
            engine.eval(script);
            engine.eval("hideBanners();");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }


    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("Проверка добовления товара в корзину")
    public void testAddingToCartAndChecking(int[] numberProduct) throws InterruptedException {
        wildberriesPage.clickButtonOkay();
        //hideBanners();
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
