
package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends TestBase {

    @BeforeEach
    void openPage() {
        Configuration.holdBrowserOpen = true;
    }
    @AfterAll
    void  closePage(){
        closeWebDriver();
    }

    @Test
    void itShouldDisplaySuggestedTrip() {
        open("https://www.kiwi.com/en/");
        //cookies
        Cookie cookie = new Cookie("cookie_consent", "agreed");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        refresh();

         //popup windows clicked by finding elements by text
        $(byText("I understand")).click();
        $(byText("Explore")).click();

    }
}
