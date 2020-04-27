
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

    @Test
    void itShouldDisplaySuggestedTrip() {
        open("https://www.kiwi.com/en/");

        // TODO: cookies
        Cookie cookie = new Cookie("cookie_consent", "agreed");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        refresh();

        //TODO: popup windows clicked by finding elements by text
        $(byText("I understand")).click();

        //TODO: verify expected result
        //predvolena destinacia je vo formulari zadana automaticky, staci kliknut na button explore
        $(byText("Explore")).click();
        //overi image not result
        $(byAttribute("alt", "no results")).shouldBe(Condition.visible);
        //overi text co sa zobrazuje na stranke ako chybova hlaska
        $(byAttribute("data-test", "AggregateResultsWrapper"))
                .shouldHave(Condition.text("We couldn't find your trip."));

    }

    @Test
    void itShouldDisplayDestinationFromKE(){
        open("https://www.kiwi.com/en/");

        // TODO: cookies
        Cookie cookie = new Cookie("cookie_consent", "agreed");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        refresh();
        
        //TODO: popup windows clicked by finding elements by text
        $(byText("I understand")).click();

    }

}

