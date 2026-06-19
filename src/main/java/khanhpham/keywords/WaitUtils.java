package khanhpham.keywords;

import khanhpham.constants.DataConfig;
import khanhpham.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

    private static int DEFAULT_TIMEOUT = Integer.parseInt(DataConfig.TIME_WAIT);

    public static WebElement waitForVisibility (WebElement element, int second){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(second));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e){
            throw new RuntimeException("Element not visible: " + element + " - " + e.getMessage());
        }
    }

    public static WebElement waitForVisibility (WebElement element){
        return waitForVisibility(element, DEFAULT_TIMEOUT);
    }


    public static WebElement waitForVisibility (By by, int second){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(second));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e){
            throw new RuntimeException("Element not visible: " + by + " - " + e.getMessage());
        }
    }

    public static WebElement waitForVisibility (By by){
        return waitForVisibility(by, DEFAULT_TIMEOUT);
    }


    public static boolean waitForInVisibility (WebElement element, int second){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(second));
            return wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e){
            throw new RuntimeException("Element visible: " + element + " - " + e.getMessage());
        }
    }

    public static boolean waitForInVisibility (WebElement element){
        return waitForInVisibility(element, DEFAULT_TIMEOUT);
    }


    public static boolean waitForInVisibility (By by, int second){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(second));
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (TimeoutException e){
            throw new RuntimeException("Element visible: " + by + " - " + e.getMessage());
        }
    }

    public static boolean waitForInVisibility (By by){
        return waitForInVisibility(by, DEFAULT_TIMEOUT);
    }

    public static WebElement waitForClickAbility(By by, int time){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(time));
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e){
            throw new RuntimeException("Element not clickable: " + by + " - " + e.getMessage());
        }
    }

    public static WebElement waitForClickAbility(WebElement element, int time){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(time));
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e){
            throw new RuntimeException("Element not clickable: " + element + " - " + e.getMessage());
        }
    }

    public static WebElement waitForClickAbility(WebElement element){
        return waitForClickAbility(element,DEFAULT_TIMEOUT);
    }

    public static WebElement waitForClickAbility(By by){
        return waitForClickAbility(by,DEFAULT_TIMEOUT);
    }

    public static List<WebElement> waitForNumberOfElementDisplay(By element, int number, int second){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second));
            return wait.until(ExpectedConditions.numberOfElementsToBe(element,number));
        } catch (TimeoutException e){
            throw new RuntimeException("Elements not display: " + element + " - " + e.getMessage());
        }
    }

    public static List<WebElement> waitForNumberOfElementDisplay(By element, int number){
        return waitForNumberOfElementDisplay(element,number,DEFAULT_TIMEOUT);
    }


    public static boolean waitForUrlContainDisplay(String url, int second){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second));
            return wait.until(ExpectedConditions.urlContains(url));
        } catch (TimeoutException e){
            throw new RuntimeException("url is display: " + url + "in time" + second + " - " + e.getMessage());
        }
    }

    public static boolean waitForUrlContainDisplay(String url){
        return waitForUrlContainDisplay(url,DEFAULT_TIMEOUT);
    }

    public static boolean waitForUrlContainNotDisplay(String url, int second){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second));
            return wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(url)));
        } catch (TimeoutException e){
            throw new RuntimeException("url not display: " + url + "in time" + second + " - " + e.getMessage());
        }
    }

    public static boolean waitForUrlContainNotDisplay(String url){
        return waitForUrlContainNotDisplay(url,DEFAULT_TIMEOUT);
    }

}
