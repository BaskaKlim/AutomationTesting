package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.WebDriverRunner.*;

public class TestBase {

    @BeforeAll

    static void configBefore() {
       // Configuration.baseUrl = "https://www.kiwi.com/en/";
        Configuration.startMaximized = true;
    }

    @AfterAll

    static void configAfter() {
        getWebDriver().quit() ;
    }

    @BeforeEach
    void openPage() {
        Configuration.holdBrowserOpen = true;
    }

}
