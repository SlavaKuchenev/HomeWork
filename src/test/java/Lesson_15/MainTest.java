package Lesson_15;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageEntity.WildberriesPage;

import java.time.Duration;

public class MainTest extends BaseTest {

    WildberriesPage wildberriesPage;
    WebDriverWait wait;

    @BeforeEach
    void initPageObject() {
        wildberriesPage = PageFactory.initElements(driver, WildberriesPage.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
