package AndroidEntity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class Pixel6Pro {
    protected AppiumDriver<AndroidElement> driver;

    By plusLocator = By.xpath("//android.widget.ImageButton[@content-desc='plus']");
    By minusLocator = By.xpath("//android.widget.ImageButton[@content-desc='minus']");
    By multiplyLocator = By.xpath("//android.widget.ImageButton[@content-desc='multiply']");
    By divideLocator = By.xpath("//android.widget.ImageButton[@content-desc='divide']");
    By pointLocator = By.xpath("//android.widget.ImageButton[@content-desc='point']");
    By textViewLocator = By.className("android.widget.TextView");
    By equalsLocator = By.xpath("//android.widget.ImageButton[@content-desc='equals']");


    public Pixel6Pro(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public void enteringNumber(double number) {
        char[] digits = String.valueOf(number).toCharArray();
        for (char digit : digits) {
            if (digit != '.') {
                clickNumber(digit);
            } else {
                clickPoint();
            }
        }
    }

    private void clickNumber(char pattern) {
        driver.findElement(By.xpath(String.format("//android.widget.ImageButton[@content-desc='%s']", pattern))).click();
    }

    private void clickPoint() {
        driver.findElement(pointLocator).click();
    }

    public void clickPlus() {
        driver.findElement(plusLocator).click();
    }

    public String valueOnScreen() {
        return driver.findElement(textViewLocator).getText();
    }
    public void clickEquals() {
        driver.findElement(equalsLocator).click();
    }
}
