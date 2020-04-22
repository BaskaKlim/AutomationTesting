package tests;

import org.junit.jupiter.api.*;
import com.codeborne.selenide.*;

public class TestBase {

    @BeforeAll
    // metodu chcem iba raz, preto static
    static void config()  {
        Configuration.baseUrl="http://ajtyvit-app.westeurope.cloudapp.azure.com:8080"  ;
        Configuration.startMaximized=true;
    }

}
