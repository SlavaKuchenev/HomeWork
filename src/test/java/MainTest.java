import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test
    public void additionTest() {
        pixel6Pro.enteringNumber(345.3);
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='2']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='plus']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='3']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='equals']")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "5");
    }

    @DataProvider(name = "TestSumData")
    public Object[][] testSumData() {
        return new Object[][]{
                {2, 3, 5},
                {5, 7, 12},
                {10, 15, 25}
        };
    }

    @Test(dataProvider = "TestSumData")
    @Description("Проверка сложения")
    public void sumTest(double number1, double number2, double expectedSum){
        pixel6Pro.enteringNumber(number1);
        pixel6Pro.clickPlus();
        pixel6Pro.enteringNumber(number2);
        pixel6Pro.clickEquals();
        Assert.assertEquals(pixel6Pro.valueOnScreen(),convertToNumberIfDecimalIsZero(expectedSum));

    }

    public String convertToNumberIfDecimalIsZero(double number) {
        String numberAsString = String.valueOf(number);
        int indexOfDot = numberAsString.indexOf('.');

        if (indexOfDot != -1 && indexOfDot == numberAsString.length() - 2) {

            return numberAsString.substring(0, indexOfDot);
        }
        return String.valueOf(number);
    }
}



