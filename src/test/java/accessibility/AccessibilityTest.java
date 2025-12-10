package accessibility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class AccessibilityTest {
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
    public void runAxeScanManually() throws Exception {
        driver.get(base + "/");

        // Load axe-core script from CDN
        URL axeUrl = new URL("https://cdnjs.cloudflare.com/ajax/libs/axe-core/4.8.2/axe.min.js");
        HttpURLConnection conn = (HttpURLConnection) axeUrl.openConnection();
        conn.setRequestMethod("GET");

        Scanner scanner = new Scanner(conn.getInputStream()).useDelimiter("\\A");
        String axeScript = scanner.hasNext() ? scanner.next() : "";
        scanner.close();

        // Inject axe-core into page
        ((JavascriptExecutor) driver).executeScript(axeScript);

        // Run axe analysis
        String axeResult = (String) ((JavascriptExecutor) driver).executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                        "axe.run().then(function(results) {" +
                        "  callback(JSON.stringify(results));" +
                        "}).catch(function(err) {" +
                        "  callback('AXE error: ' + err); });"
        );

        System.out.println("Accessibility scan result:");
        System.out.println(axeResult);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) driver.quit();
    }
}