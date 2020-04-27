package tests;

import org.junit.jupiter.api.*;
import com.codeborne.selenide.*;

public class TestBase {

    @BeforeAll
    // metodu chcem iba raz, preto static
    static void config()  {
      //  Configuration.baseUrl="https://www.kiwi.com/en/"  ;
       // Configuration.startMaximized=true;
    }

}
