package khanhpham.tests;

import khanhpham.common.BaseClass;
import khanhpham.constants.DataConfig;
import khanhpham.drivers.DriverManager;
import khanhpham.keywords.WaitUtils;
import khanhpham.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    private LoginPage loginPage;

    @BeforeMethod
    public void initPage() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().get(URL);
        }

        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void verifyAllElementOfLoginPage() {
        Assert.assertTrue(loginPage.isButtonLoginDisplay());
        Assert.assertTrue(loginPage.isButtonRegisterDisplay());

        Assert.assertEquals(loginPage.getButtonLoginText(), "Đăng nhập");
        Assert.assertEquals(loginPage.getButtonRegisterText(), "Đăng ký");

        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isTitleLoginDisplay());
        Assert.assertEquals(loginPage.getTextLoginTitle(),"Đăng nhập AIMICA");

        Assert.assertTrue(loginPage.isLoginDescriptionDisplay());
        Assert.assertEquals(loginPage.getTextLoginDescription(),"Nhập số điện thoại — chúng tôi sẽ gửi mã OTP để xác thực.");

        Assert.assertTrue(loginPage.isPhoneLabelDisplay());
        Assert.assertEquals(loginPage.getTextPhoneLabel(),"Số điện thoại");
        Assert.assertEquals(loginPage.getPhoneFieldText(), "0912 345 678");

        DriverManager.getDriver().get(URL);

        loginPage.clickRegister();
        Assert.assertEquals(loginPage.getNameFieldText(), "VD: Trần Ngọc Linh");
    }

    @Test(priority = 2)
    public void testSuccessfulRegistration() {
        String randomPhone = "039" + (1000000 + (int)(Math.random() * 9000000));

        loginPage.registerFlow(randomPhone, "Khanh Pham", DataConfig.TEST_OTP);

        WaitUtils.waitForUrlContainNotDisplay("otp");

        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("otp"));
    }

    @Test(priority = 3)
    public void testSuccessfulLogin() {
        loginPage.loginFlow(DataConfig.TEST_PHONE, DataConfig.TEST_OTP);

        WaitUtils.waitForUrlContainNotDisplay("otp");

        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("otp"));
    }

    @Test(priority = 4)
    public void testLoginWithIncorrectOTP() {
        loginPage.loginFlow(DataConfig.TEST_PHONE, "999999");

        Assert.assertTrue(loginPage.isErrorMessageDisplay());
        Assert.assertTrue(loginPage.getErrorMessageText().contains("không hợp lệ"));
    }
}