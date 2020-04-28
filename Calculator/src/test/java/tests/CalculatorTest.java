
package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
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

    String firstNum = "1";
    String secondNum = "4";

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "1, 2, 3",
            "2, 5, 7",
            "4, 8, 12"
    })

    void itShouldSumTwoNumbersParametrized(String firstNumber, String secondNumber, String result) {

        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNumber);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNumber);
        //3.kliknem na tlacidlo spocitaj
        $(byId("count")).click();
        //4.overim vysledok
        $(byId("result")).shouldHave(Condition.exactText(result));
    }

    @Test
    void itShouldDeductTwoNumbers() {
        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNum);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNum);
        //3.kliknem na tlacidlo spocitaj
        $(byId("deduct")).click();
        //4.overim vysledok
        $(byId("result")).shouldHave(Condition.exactText("-3"));

    }

    @Test
    void itShouldMultiplyTwoNumbers() {
        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNum);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNum);
        //3.kliknem na tlacidlo spocitaj
        $(byId("multiply")).click();
        //4.overim vysledok
        $(byId("result")).shouldHave(Condition.exactText("4"));

    }

    @Test
    void itShouldDivideTwoNumbers() {
        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNum);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNum);
        //3.kliknem na tlacidlo spocitaj
        $(byId("divide")).click();
        //4.overim vysledok
        $(byId("result")).shouldHave(Condition.exactText("0.25"));
    }

    @Test
    void itShouldResretCalculatorInputs() {
        //1.zadam cislo do prveho inputu
        enterFirstInput(firstNum);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNum);
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
        enterFirstInput(firstNum);
        //2.zadam cislo do druheho inputu
        enterSecondInput(secondNum);
        //3.kliknem na tlacidlo spocitaj
        $(byId("count")).click();
        //4.overim vysledok
        $(byText(getResetButtonText())).click();
        $(byId("result")).shouldBe(Condition.empty);

    }


    @Test
    void itShoulDisplay() {

        enterFirstInput(firstNum);
        enterSecondInput(secondNum);
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
