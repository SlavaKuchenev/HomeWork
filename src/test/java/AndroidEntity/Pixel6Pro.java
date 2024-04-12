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
    By clearLocator = By.xpath("//android.widget.ImageButton[@content-desc='clear']");


    public Pixel6Pro(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public void enteringNumber(double number) {
        String numberString = String.valueOf(convertToNumberIfDecimalIsZero(number));
        for (char digit : numberString.toCharArray()) {
            if (digit == '.') {
                clickPoint();
            } else if (digit == '-') {
                clickMinus();
            } else {
                clickNumber(digit);
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

    public void clickMinus() {
        driver.findElement(minusLocator).click();
    }
    public void clickclear() {
        driver.findElement(clearLocator).click();
    }

    public Number convertToNumberIfDecimalIsZero(double number) {
        String numberAsString = String.valueOf(number);
        int indexOfDot = numberAsString.indexOf('.');

        if (indexOfDot != -1 && indexOfDot == numberAsString.length() - 2 && numberAsString.charAt(indexOfDot + 1) == '0') {
            numberAsString = numberAsString.substring(0, indexOfDot);
            if (numberAsString.startsWith("-")) {
                return Double.parseDouble(numberAsString);
            } else {
                return Integer.parseInt(numberAsString);
            }
        }
        return number;
    }
}
