import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @DataProvider(name = "TestSumData")
    public Object[][] testSumData() {
        return new Object[][]{
                {2, 3, "5"},
                {-123.45, 3, "−120.45"},
                {0, -15, "−15"},
                {2.1, 1.5, "3.6"}
        };
    }

    @Test(dataProvider = "TestSumData")
    @Feature("Калькулятор")
    @Story("Проверка сложения")
    @Description("Проверка сложения")
    public void sumTest(double number1, double number2, String expectedSum) {
        pixel6Pro.clickclear();
        pixel6Pro.enteringNumber(number1);
        pixel6Pro.clickPlus();
        pixel6Pro.enteringNumber(number2);
        pixel6Pro.clickEquals();
        Assert.assertEquals(pixel6Pro.valueOnScreen(), expectedSum);
    }

    @DataProvider(name = "TestMinusData")
    public Object[][] testMinusData() {
        return new Object[][]{
                {2, 3, "−1"},
                {-123.45, 3, "−126.45"},
                {0, -15, "−15"},
                {2.1, 1.5, "0.6"}
        };
    }

    @Test(dataProvider = "TestMinusData")
    @Feature("Калькулятор")
    @Story("Проверка вычитания")
    @Description("Проверка вычитания")
    public void minusTest(double number1, double number2, String expectedSum) {
        pixel6Pro.clickclear();
        pixel6Pro.enteringNumber(number1);
        pixel6Pro.clickMinus();
        pixel6Pro.enteringNumber(number2);
        pixel6Pro.clickEquals();
        Assert.assertEquals(pixel6Pro.valueOnScreen(), expectedSum);
    }

    @DataProvider(name = "TestMultiplyData")
    public Object[][] testMultiplyData() {
        return new Object[][]{
                {2, 3, "6"},
                {-123.45, 3, "−370.35"},
                {0, -15, "0"},
                {-2.1, -1.5, "3.15"}
        };
    }

    @Test(dataProvider = "TestMultiplyData")
    @Feature("Калькулятор")
    @Story("Проверка умножения")
    @Description("Проверка умножения")
    public void multiplyTest(double number1, double number2, String expectedSum) {
        pixel6Pro.clickclear();
        pixel6Pro.enteringNumber(number1);
        pixel6Pro.clickMultiply();
        pixel6Pro.enteringNumber(number2);
        pixel6Pro.clickEquals();
        Assert.assertEquals(pixel6Pro.valueOnScreen(), expectedSum);
    }

    @DataProvider(name = "TestDivideData")
    public Object[][] testDivideData() {
        return new Object[][]{
                {2, 3, "0.6666666666666"},
                {-123.45, 3, "−41.15"},
                {0, -15, "0"},
                {-2.1, -1.5, "1.4"},
                {-2.1, 0, "Can't divide by 0"}
        };
    }

    @Test(dataProvider = "TestDivideData")
    @Feature("Калькулятор")
    @Story("Проверка деления")
    @Description("Проверка деления")
    public void divideTest(double number1, double number2, String expectedSum) {
        pixel6Pro.clickclear();
        pixel6Pro.enteringNumber(number1);
        pixel6Pro.clickDivide();
        pixel6Pro.enteringNumber(number2);
        pixel6Pro.clickEquals();
        Assert.assertEquals(pixel6Pro.valueOnScreen(), expectedSum);
    }
}



