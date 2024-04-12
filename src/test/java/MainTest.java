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
    @Description("Проверка сложения")
    public void sumTest(double number1, double number2, String expectedSum){
        pixel6Pro.clickclear();
        pixel6Pro.enteringNumber(number1);
        pixel6Pro.clickPlus();
        pixel6Pro.enteringNumber(number2);
        pixel6Pro.clickEquals();
        Assert.assertEquals(pixel6Pro.valueOnScreen(),expectedSum);
    }
}



