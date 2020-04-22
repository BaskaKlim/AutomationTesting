
package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CalculatorTest extends TestBase{

    @BeforeEach
    void openPage() {
        //1. open the website
        open("/kalkulacka.php");
    }

    String firstNumber = "1";
    String secondNumber = "4";

    @Test
    void itShouldSumTwoNumbers() {

        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNumber);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNumber);
        //3.kliknem na tlacidlo spocitaj
        $(byId("count")).click();
        //4.overim vysledok
        $(byId("result")).shouldHave(Condition.exactText("5"));
    }

    @Test
    void itShouldDeductTwoNumbers() {
        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNumber);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNumber);
        //3.kliknem na tlacidlo spocitaj
        $(byId("deduct")).click();
        //4.overim vysledok
        $(byId("result")).shouldHave(Condition.exactText("-3"));

    }

    @Test
    void itShouldMultiplyTwoNumbers() {
        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNumber);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNumber);
        //3.kliknem na tlacidlo spocitaj
        $(byId("multiply")).click();
        //4.overim vysledok
        $(byId("result")).shouldHave(Condition.exactText("4"));

    }

    @Test
    void itShouldDivideTwoNumbers() {
        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNumber);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNumber);
        //3.kliknem na tlacidlo spocitaj
        $(byId("divide")).click();
        //4.overim vysledok
        $(byId("result")).shouldHave(Condition.exactText("0.25"));
    }

    @Test
    void itShouldResretCalculatorInputs() {
        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNumber);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNumber);
        //3.kliknem na tlacidlo spocitaj
        $(byId("count")).click();
        $(byText(getResetButtonText())).click();
        $(byId("firstInput")).shouldHave(Condition.value(""));
        $(byId("secondInput")).shouldBe(Condition.empty);
        $(byId("firstInput")).shouldHave(Condition.attribute("placeholder", "prve cislo"));

    }

    @Test
    void itShouldResretCalculatorResult() {
        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNumber);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNumber);
        //3.kliknem na tlacidlo spocitaj
        $(byId("count")).click();
        //4.overim vysledok
        $(byText(getResetButtonText())).click();
        $(byId("result")).shouldBe(Condition.empty);

    }


    @Test
    void itShoulDisplay() {

        enterFirstInput(firstNumber);
        enterSecondInput(secondNumber);
        $(byId("count")).click();
        $$(By.cssSelector("ul.latest-resilts li")).shouldHave(CollectionCondition.size(1));
    }


    void enterFirstInput(String input) {
        $(byId("firstInput")).val(input);
    }

    void enterSecondInput(String input) {
        $(byId("secondInput")).val(input);
    }

    private String getResetButtonText(){
        return "Vynuluj" ;
    }

}
