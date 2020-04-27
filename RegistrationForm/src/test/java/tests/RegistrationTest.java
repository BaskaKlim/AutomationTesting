
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
        //Configuration.timeout = 6000;
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
        //TODO: 7. click registruj batton
        pressRegistrationButton();

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
        //TODO: 7. click registruj batton
        pressRegistrationButton();
    }

    /**
     * ___________________Methods_______________________________
     **/

    void enterEmailInput(String input) {
        $(By.xpath("//form/div[1]/input")).val(input);
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

   /* void ceckRobotCheckBox() {
        $(byCssSelector("input#checkbox")).click();
    }
   */

    void pressRegistrationButton() {
        $(byCssSelector("button.btn-success")).click();
    }

}
