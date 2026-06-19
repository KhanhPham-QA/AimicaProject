package khanhpham.constants;

import khanhpham.helpers.PropertiesHelpers;

public class DataConfig {

    private DataConfig(){

    }

    static {
        PropertiesHelpers.setFile("src/test/resources/config/config.properties");
    }

    public static String URL = PropertiesHelpers.getValue("URL");
    public static String TEST_PHONE = PropertiesHelpers.getValue("TEST_PHONE");
    public static String TEST_OTP = PropertiesHelpers.getValue("TEST_OTP");
    public static String TIME_WAIT = PropertiesHelpers.getValue("TIME_WAIT");
    public static String TIME_SERVICE = PropertiesHelpers.getValue("TIME_SERVICE");
}
