package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class UiRegressionTest {
    private WebDriver driver;
    private String base;

    @BeforeClass
    public void setup() {
        base = System.getProperty("base.url", "http://localhost:8080");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void homepageLoads() {
        driver.get(base + "/");
        Assert.assertTrue(driver.getTitle() != null && !driver.getTitle().isBlank(),
                "Homepage should have a title");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) driver.quit();
    }
}