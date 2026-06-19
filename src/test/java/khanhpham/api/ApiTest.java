package khanhpham.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import khanhpham.constants.DataConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;

public class ApiTest {

    private static String token;
    private static String requestId;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = DataConfig.URL;
        RestAssured.requestSpecification = given().contentType(ContentType.JSON);
    }

    @Test(priority = 1)
    public void sendOtpSuccess() {
        requestId = given()
                .body("{\"phone\":\"" + DataConfig.TEST_PHONE + "\",\"flow\":\"LOGIN\"}")
                .post("/api/proxy/api/auth/otp/send")
                .then()
                .statusCode(200)
                .body("requestId", isA(String.class))
                .extract().path("requestId");
    }

    @Test(priority = 2)
    public void sendOtpInvalidPhone() {
        given()
                .body("{\"phone\":\"123\",\"flow\":\"LOGIN\"}")
                .post("/api/proxy/api/auth/otp/send")
                .then()
                .statusCode(400);
    }

    @Test(priority = 3)
    public void verifyOtpSuccess() {
        token = given()
                .header("x-otp-id", requestId)
                .header("x-otp-code", DataConfig.TEST_OTP)
                .header("x-otp-phone", DataConfig.TEST_PHONE)
                .body("{\"phone\":\"" + DataConfig.TEST_PHONE + "\"}")
                .post("/api/proxy/api/auth/login")
                .then()
                .statusCode(200)
                .body("user.uid", isA(String.class))
                .body("user.phone", isA(String.class))
                .extract().cookie("aaa_at");
    }

    @Test(priority = 4)
    public void verifyOtpInWrongOTP() {
        given()
                .header("x-otp-id", requestId)
                .header("x-otp-code", "999999")
                .header("x-otp-phone", DataConfig.TEST_PHONE)
                .body("{\"phone\":\"" + DataConfig.TEST_PHONE + "\"}")
                .post("/api/proxy/api/auth/login")
                .then()
                .statusCode(400);
    }

    @Test(priority = 5)
    public void getUserProfileSuccess() {
        given()
                .cookie("aaa_at", token)
                .get("/api/proxy/api/auth/me")
                .then()
                .statusCode(200)
                .body("phone", equalTo(DataConfig.TEST_PHONE))
                .body("phone", isA(String.class))
                .body("uid", isA(String.class));
    }

    @Test(priority = 6)
    public void getUserProfileUnauthenticated() {
        given()
                .get("/api/proxy/api/auth/me")
                .then()
                .statusCode(401);
    }
}

