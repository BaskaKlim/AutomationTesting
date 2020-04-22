
package tests;

import org.junit.jupiter.api.*;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ClickMeBabyTest {

    @BeforeEach
    void openPage(){
        //1. open the website
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
    }

    @Test
    void itShouldDisplayOneClick() {

        //2. click to button "click me baby"
        $(byId("clickMe")).click();
        //3. validate the number of clicks
        $(byId("clicks")).shouldHave(Condition.text("1"));
        //4.validate text "klik"
        $(byCssSelector("p.description")).shouldHave(Condition.text("klik"));

    }
    @Test
    void itShouldDisplayTwoClicks() {
        //2. click to button "click me baby"
        $(byId("clickMe")).click();
        $(byId("clickMe")).click();
        //3. validate the number of clicks
        $(byId("clicks")).shouldHave(Condition.text("2"));
        //4.validate text "kliky"
        $(byCssSelector("p.description")).shouldHave(Condition.text("kliky"));
    }


    @Test
    void itShouldDisplay5Clicks() {
        //2. click to button "click me baby"
        for (int i = 0; i < 5; i++) {
            $(byId("clickMe")).click();
        }
        //3. validate the number of clicks
        $(byId("clicks")).shouldHave(Condition.text("5"));
        //4.validate text "klikov"
        $(byCssSelector("p.description")).shouldHave(Condition.text("klikov"));
    }

    @Test
    void itShouldDisplayZeroClicksOnPageOpen() {
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        $(byId("clicks")).shouldHave(Condition.text("0"));
        $(byCssSelector("p.description")).shouldHave(Condition.text("klikov"));
    }

    @Test
    void itShouldDisplayCorrectTextForClickMeButton() {
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        $(byId("clickMe")).shouldHave(Condition.text("Click me !"));
    }

    @Test
    void itShouldDisplayHeading() {
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        $(byCssSelector("h1"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("Click me baby one more time"));

    }
}
