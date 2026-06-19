# Aimica Automation Testing

Dự án automation test cho hệ thống Aimica (bao gồm UI test với Selenium và API test với RestAssured).

## Yêu cầu hệ thống
- Java JDK 21
- Maven
- Trình duyệt Google Chrome
- Allure Commandline (để tạo báo cáo)

## Thư viện sử dụng
- Selenium Java (v4.14.1)
- RestAssured (v5.4.0)
- TestNG (v7.10.2)
- Allure TestNG (v2.29.1)

## Cấu hình
Thông tin cấu hình nằm ở file `src/test/resources/config/config.properties`:
- URL: Link môi trường test.
- TEST_PHONE: Số điện thoại test.
- TEST_OTP: Mã OTP test mặc định (000000).

## Cách chạy test
Chạy toàn bộ test:
```bash
mvn clean test
```

Chạy riêng UI test:
```bash
mvn test -Dtest=LoginTest
```

Chạy riêng API test:
```bash
mvn test -Dtest=ApiTest
```

## Báo cáo Allure
Để xem báo cáo sau khi chạy test, chạy lệnh sau ở terminal:
```bash
allure serve allure-results
```
