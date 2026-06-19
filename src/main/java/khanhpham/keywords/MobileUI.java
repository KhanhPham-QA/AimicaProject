package khanhpham.keywords;

import io.qameta.allure.Step;
import khanhpham.constants.DataConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileUI {
    private static final int SLOW_TIMEOUT = Integer.parseInt(DataConfig.TIME_WAIT);

    public static void clickElement (By locator, int second){
        System.out.println("UI Clicking element located is: " + locator + " within " + second);
        WaitUtils.waitForClickAbility(locator, second).click();
    }

    public static void clickElement (By locator){
        clickElement(locator, SLOW_TIMEOUT);
    }

    public static void clickElement (WebElement locator, int second){
        System.out.println("UI Clicking element located is: " + locator + " within " + second);
        WaitUtils.waitForClickAbility(locator, second).click();
    }

    public static void clickElement (WebElement locator){
        clickElement(locator, SLOW_TIMEOUT);
    }

    public static void setText (By locator, String text, int second){
        System.out.println("UI Setting text '" + text + "' on element located is: " + locator);
        WebElement element = WaitUtils.waitForVisibility(locator, second);
        element.click();
        element.clear();
        element.sendKeys(text);
        System.out.println("UI Set text completed on locator: " + locator);
    }

    public static void setText (By locator, String text){
        setText(locator, text, SLOW_TIMEOUT);
    }

    public static void setText (WebElement locator, String text, int second){
        System.out.println("UI Setting text '" + text + "' on element located is: " + locator);
        WebElement element = WaitUtils.waitForVisibility(locator, second);
        element.click();
        element.clear();
        element.sendKeys(text);
        System.out.println("UI Set text completed on locator: " + locator);
    }

    public static void setText (WebElement locator, String text){
        setText(locator, text, SLOW_TIMEOUT);
    }


    public static String getTextOfElement (By locator, int second){
        System.out.println("UI Getting text from element located is: " + locator + " with timeout " + second + "s.");
        WebElement element = WaitUtils.waitForVisibility(locator, second);
        String text = element.getText();
        System.out.println("UI Retrieved text: '" + text + "'");
        return text;
    }

    public static String getTextOfElement (By locator){
        return getTextOfElement(locator, SLOW_TIMEOUT);
    }

    public static String getTextOfElement (WebElement locator, int second){
        System.out.println("UI Getting text from element located by: " + locator + " with timeout " + second);
        WebElement element = WaitUtils.waitForVisibility(locator, second);
        String text = element.getText();
        System.out.println("UI Retrieved text: '" + text + "'");
        return text;
    }

    public static String getTextOfElement (WebElement locator){
        return getTextOfElement(locator, SLOW_TIMEOUT);
    }

    public static boolean isElementPresentDisplay (By locator, int second){
        System.out.println("UI Checking is displaying on locator: " + locator);
        try {
            boolean result = WaitUtils.waitForVisibility(locator, second).isDisplayed();
            System.out.println("UI Result: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("UI An error occurred display: " + e.getMessage());
            return false;
        }
    }

    public static boolean isElementPresentDisplay (By locator){
        return isElementPresentDisplay(locator, SLOW_TIMEOUT);
    }

    public static boolean isElementPresentDisplay (WebElement locator, int second){
        System.out.println("UI Checking is displaying on locator: " + locator);
        try {
            boolean result = WaitUtils.waitForVisibility(locator, second).isDisplayed();
            System.out.println("UI Result: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("UI An error occurred display: " + e.getMessage());
            return false;
        }
    }

    public static boolean isElementPresentDisplay (WebElement locator){
        return isElementPresentDisplay(locator, SLOW_TIMEOUT);
    }

    public static void clearText (By locator, int second){
        System.out.println("UI Clearing text on element: " + locator + " with timeout " + second);
        WebElement element = WaitUtils.waitForVisibility(locator,second);
        element.click();
        element.clear();
        System.out.println("UI Clear completed for locator: " + locator);
    }

    public static void clearText (By locator){
        clearText(locator,SLOW_TIMEOUT);
    }

    public static void clearText (WebElement locator, int second){
        System.out.println("UI Clearing text on element: " + locator + " with timeout " + second);
        WebElement element = WaitUtils.waitForVisibility(locator,second);
        element.click();
        element.clear();
        System.out.println("UI Clear completed for locator: " + locator);
    }

    @Step ("Clear text on element {0}")
    public static void clearText (WebElement locator){
        clearText(locator,SLOW_TIMEOUT);
    }

}
