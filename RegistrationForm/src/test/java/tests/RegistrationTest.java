
package tests;

import java.util.concurrent.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends TestBase {

    @BeforeEach
    void openPage() {
        //1. open the website
        open("/registracia.php");
        Configuration.timeout = 6000;
        //javascript configuracia na clickatelny checkbox
        Configuration.clickViaJs = true;
    }

    String firstName = "Barbara";
    String lastName = "Klimek";
    String email = "baska.klimekova@gmail.com";
    String password = "123456";
    String wrongPassword = "4444";

    @Test
    void itShouldPassRegistration() {

        //TODO: 1.zadam email do prveho inputu
        enterEmailInput(email);
        //TODO: 2.zadam meno do druheho inputu
        enterFirstNameInput(firstName);
        //TODO: 3.zadam priezvisko do tretieho inputu
        enterLastNameInput(lastName);
        //TODO: 4. a 5. zadam heslo a zopakujem ho
        enterPasswordInput(password);
        enterPasswordRepeatInput(password);
        //TODO: 6. zaklikni som robot
        ceckRobotCheckBox();
        //TODO: 7. click registruj batton
        pressRegistrationButton();
        //TODO: 8. over hlasku
        validateSuccess();
    }

    @Test
    void itShouldFailRegWrongPassword() {

        //TODO: 1.zadam email do prveho inputu
        enterEmailInput(email);
        //TODO: 2.zadam meno do druheho inputu
        enterFirstNameInput(firstName);
        //TODO: 3.zadam priezvisko do tretieho inputu
        enterLastNameInput(lastName);
        //TODO: 4. a 5. zadam heslo a zopakujem ho
        enterPasswordInput(wrongPassword);
        enterPasswordRepeatInput(wrongPassword);
        //TODO: 6. zaklikni som robot
        ceckRobotCheckBox();
        //TODO: 7. click registruj button
        pressRegistrationButton();
        //TODO: 8. over hlasku
        validateSuccess();
    }

    /**
     * ___________________Methods_______________________________
     **/

    void enterEmailInput(String input) {
        $(byXpath("//form/div[1]/input")).val(input);
    }

    void enterFirstNameInput(String input) {
        $(byXpath("/html/body/div/div/form/div[2]/input")).val(input);
    }

    void enterLastNameInput(String input) {
        $(byName("surname")).val(input);
    }

    void enterPasswordInput(String input) {
        $(byName("password")).val(input);
    }

    void enterPasswordRepeatInput(String input) {
        $(byName("password-repeat")).val(input);
    }

    void ceckRobotCheckBox() {
        /** checkbox hlasi chybu, ze checkbox nie je clicable element, pretoze sa prekryvaju s label... **/
        $(byCssSelector("input#checkbox")).click();
        // $(byAttribute("name","robot")).click();
    }

    void pressRegistrationButton() {
        $(byCssSelector("button.btn-success")).click();
    }

    void validateSuccess(){
        $("div.alert-success").
                shouldBe(Condition.visible).
                shouldHave(Condition.exactText("Registracia uspesna!"));

    }

}
