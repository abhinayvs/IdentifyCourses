package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

    public static WebDriver driver;
    public static Properties props;

    public static void initialize() throws IOException {
        props = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
        props.load(file);	

        String browser = props.getProperty("browser");
        switch(browser.toLowerCase()) {
        case "chrome":
        	driver = new ChromeDriver();
        	break;
        case "edge":
        	driver = new EdgeDriver();
        	break;
        case "firefox":
        	driver = new FirefoxDriver();
        	break;
        default:
        	System.out.println("Invalid browser");
        	return;
        }
        driver.manage().window().maximize();
        driver.get(props.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
