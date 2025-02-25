package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup {

    public static WebDriver driver;
    public static Properties props;

    public static void initialize() throws IOException {
        props = new Properties();
        FileInputStream file = new FileInputStream("C:\\Automation\\workspace\\IdentifyCourses\\src\\test\\resources\\config.properties");
        props.load(file);	
        String browser = props.getProperty("browser");
        String mode = props.getProperty("mode");
        String huburl = "http://localhost:4444/wd/hub";
        System.out.println("Execution Environment: " + props.getProperty("execution_env"));
        System.out.println("Browser: " + browser);
        System.out.println("Mode: " + mode);

        if(props.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities cap = new DesiredCapabilities();
            switch(browser.toLowerCase()) {
                case "chrome" : 
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (mode.equalsIgnoreCase("headless")) {
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--disable-gpu"); // Optional, for Windows OS
                    }
                    cap.merge(chromeOptions);
                    cap.setBrowserName("chrome"); 
                    break;

                case "edge" : 
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (mode.equalsIgnoreCase("headless")) {
                        edgeOptions.addArguments("--headless");
                    }
                    cap.merge(edgeOptions);
                    cap.setBrowserName("MicrosoftEdge"); 
                    break;
                default : 
                    System.out.println("Invalid browser"); 
                    return;
            }
            try {
                driver = new RemoteWebDriver(new URL(huburl), cap);
            } catch (Exception e) {
                System.out.println("Failed to initialize remote WebDriver: " + e.getMessage());
                return;
            }
        } else if(props.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch(browser.toLowerCase()) {
                case "chrome" : 
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (mode.equalsIgnoreCase("headless")) {
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--disable-gpu"); // Optional, for Windows OS
                    }
                    driver = new ChromeDriver(chromeOptions); 
                    break;
                case "edge" : 
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (mode.equalsIgnoreCase("headless")) {
                        edgeOptions.addArguments("--headless");
                    }
                    driver = new EdgeDriver(edgeOptions); 
                    break;
                default : 
                    System.out.println("Invalid browser"); 
                    return;
            }
        } else {
            System.out.println("Invalid execution environment");
            return;
        }

        if (driver != null) {
            driver.manage().window().maximize();
            driver.get(props.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else {
            System.out.println("Driver initialization failed");
        }
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
