package khanhpham.common;

import khanhpham.constants.DataConfig;
import khanhpham.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {

    protected final String URL = DataConfig.URL;

    @BeforeClass(alwaysRun = true)
    public void setUpDriver (){
        System.out.println("Initialize Chrome execution");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(URL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownDriver (){
        if (DriverManager.getDriver() != null){
            DriverManager.getDriver().quit();
            DriverManager.teaDownDriver();
        }
    }
}
