package khanhpham.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver (WebDriver data){
        driver.set(data);
    }

    public static WebDriver getDriver (){
        return driver.get();
    }

    public static void teaDownDriver (){
        if (getDriver() != null){
            getDriver().quit();
            driver.remove();
        }
    }


}
