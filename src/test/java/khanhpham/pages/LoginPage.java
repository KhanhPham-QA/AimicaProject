package khanhpham.pages;

import khanhpham.drivers.DriverManager;
import khanhpham.keywords.MobileUI;
import khanhpham.keywords.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    private final By buttonLogin = By.xpath("//*[contains(text(), 'Đăng nhập')]");
    private final By buttonRegister = By.xpath("//button[text()='Đăng ký']");
    private final By loginTitle = By.xpath("//h1[text()='Đăng nhập AIMICA']");
    private final By loginDescription = By.xpath("//p[contains(text(), 'Nhập số điện thoại')]");
    private final By phoneLabel = By.xpath("//div[text()='Số điện thoại']");
    private final By phoneInput = By.xpath("//input[contains(@placeholder, '0912')]");
    private final By nameInput = By.xpath("//input[contains(@placeholder, 'Trần Ngọc Linh')]");
    private final By buttonContinueOtp = By.xpath("//button[contains(., 'Tiếp tục') or contains(., 'Gửi mã OTP')]");
    private final By buttonGetOtp = By.xpath("//button[contains(text(), 'Xác thực') or contains(text(), 'tạo tài khoản')]");
    private final By allOtpField = By.xpath("//input");

    private final By errorAlert = By.xpath("//*[contains(@class, 'error') or contains(text(), 'không hợp lệ')]");

    public LoginPage() {
    }

    public void clickRegister() {
        MobileUI.clickElement(buttonRegister);
    }

    public void clickLogin() {
        MobileUI.clickElement(buttonLogin);
    }

    private void inputFullOtp (String otp){
        System.out.println("Input full OTP in all fields");
        WaitUtils.waitForNumberOfElementDisplay(allOtpField,6);
        List<WebElement> listField = DriverManager.getDriver().findElements(allOtpField);

        for (int i = 0; i < listField.size(); i++){
            char tempData = otp.charAt(i);
            listField.get(i).sendKeys(String.valueOf(tempData));
        }
    }

    public void registerFlow(String phone, String name, String otp) {
        MobileUI.clickElement(buttonRegister);
        MobileUI.setText(phoneInput, phone);
        MobileUI.setText(nameInput, name);
        MobileUI.clickElement(buttonContinueOtp);

        inputFullOtp(otp);
        MobileUI.clickElement(buttonGetOtp);
    }

    public void loginFlow(String phone, String otp) {
        MobileUI.clickElement(buttonLogin);
        MobileUI.setText(phoneInput, phone);
        MobileUI.clickElement(buttonContinueOtp);

        inputFullOtp(otp);
        MobileUI.clickElement(buttonGetOtp);
    }

    public boolean isTitleLoginDisplay (){
        return MobileUI.isElementPresentDisplay(loginTitle);
    }

    public String getTextLoginTitle (){
        return MobileUI.getTextOfElement(loginTitle);
    }

    public boolean isLoginDescriptionDisplay (){
        return MobileUI.isElementPresentDisplay(loginDescription);
    }

    public String getTextLoginDescription (){
        return MobileUI.getTextOfElement(loginDescription);
    }

    public boolean isPhoneLabelDisplay (){
        return MobileUI.isElementPresentDisplay(phoneLabel);
    }

    public String getTextPhoneLabel (){
        return MobileUI.getTextOfElement(phoneLabel);
    }

    public boolean isButtonLoginDisplay() {
        return MobileUI.isElementPresentDisplay(buttonLogin);
    }

    public String getButtonLoginText() {
        return MobileUI.getTextOfElement(buttonLogin);
    }

    public boolean isButtonRegisterDisplay() {
        return MobileUI.isElementPresentDisplay(buttonRegister);
    }

    public String getButtonRegisterText() {
        return MobileUI.getTextOfElement(buttonRegister);
    }

    public boolean isErrorMessageDisplay() {
        return MobileUI.isElementPresentDisplay(errorAlert);
    }

    public String getErrorMessageText() {
        return MobileUI.getTextOfElement(errorAlert);
    }


    public String getPhoneFieldText() {
        return DriverManager.getDriver().findElement(phoneInput).getAttribute("placeholder");
    }

    public String getNameFieldText() {
        return DriverManager.getDriver().findElement(nameInput).getAttribute("placeholder");
    }
}