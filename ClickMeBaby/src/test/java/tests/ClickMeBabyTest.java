
package tests;

import org.junit.jupiter.api.*;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ClickMeBabyTest {

    @Test
    void itShouldDisplayOneClick() {
        //1. open the website
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        //2. click to button "click me baby"
        $(byId("clickMe")).click();
        //3. validate the number of clicks
        $(byId("clicks")).shouldHave(Condition.text("1"));
        //4.validate text "klik"
        $(byCssSelector("p.description")).shouldHave(Condition.text("klik"));

    }
    @Test
    void itShouldDisplayTwoClicks() {
        //1. open the website
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        //2. click to button "click me baby"
        $(byId("clickMe")).click();
        $(byId("clickMe")).click();
        //3. validate the number of clicks
        $(byId("clicks")).shouldHave(Condition.text("2"));
        //4.validate text "kliky"
        $(byCssSelector("p.description")).shouldHave(Condition.text("kliky"));
    }
}
