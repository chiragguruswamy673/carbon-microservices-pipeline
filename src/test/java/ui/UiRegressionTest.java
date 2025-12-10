package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class UiRegressionTest {
    private WebDriver driver;
    private String base;

    @BeforeClass
    public void setup() {
        base = System.getProperty("base.url", "http://localhost:8080");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");          // run without GUI
        options.addArguments("--no-sandbox");            // required in CI
        options.addArguments("--disable-dev-shm-usage"); // avoid /dev/shm issues
        options.addArguments("--remote-allow-origins=*"); // keep compatibility

        driver = new ChromeDriver(options);
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