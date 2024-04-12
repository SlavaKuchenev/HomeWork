package Lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageEntity.WildberriesPage;


import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WildberriesPage wildberriesPage;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        wildberriesPage = new WildberriesPage(driver);
        driver.get("https://www.wildberries.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
