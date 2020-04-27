
package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends TestBase {
    

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
    void itShouldDisplayDestinationFromKE() {
        open("https://www.kiwi.com/en/");

        // TODO: cookies
        Cookie cookie = new Cookie("cookie_consent", "agreed");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        refresh();

        //TODO: popup windows clicked by finding elements by text
        $(byText("I understand")).click();

        //TODO: change default location to Kosice, choose first destination, show results and write price to console
        //close x button with location
        $(byAttribute("data-test", "PlacePickerInputPlace-close")).click();
        //find input field end enter value Kosice
        $(byAttribute("data-test", "SearchField-input")).val("Košice");
        // choose from rollups option first one with clickable checkbox, hover must be add / bez toho to nejde
        $(byAttribute("data-test", "PlacePickerRow-city")).hover().click();
        //click button Explore and searching connections
        $(byText("Explore")).click();


        // click to first finded destination
        $(byAttribute("data-test", "PictureCardContent")).click();
        //wait until result of action will be visible
        $(byAttribute("data-test", "ResultCardWrapper"))
                .waitUntil(Condition.visible, 10000);
        // for each atribute price, print it itno console 
        $$(byAttribute("data-test", "ResultCardPrice")).forEach(element -> System.out.println(element.getText()));
    }

}



