import AndroidEntity.Pixel6Pro;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class BaseTest {
    protected AppiumDriver<AndroidElement> driver;
    protected Pixel6Pro pixel6Pro;
    protected String sessionUUID;

    @BeforeTest
    public void setup() {
        sessionUUID = UUID.randomUUID().toString();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
            driver = new AndroidDriver<>(new URL(APPIUM_URL), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            pixel6Pro = new Pixel6Pro(driver);
            driver.setLogLevel(Level.INFO);
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
    }
}

