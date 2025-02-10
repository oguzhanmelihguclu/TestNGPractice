package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBaseCross {
    // Crossbrowser calisacak class'lar icin
    // .xml'den gonderilen calisacakBrowser parametresini yakalayip
    // o browser'a uygun bir driver olusturup
    // Class'in kullanmasina hazir hale getirecek

    protected WebDriver driver;

    @Parameters("kullanilacakBrowser")
    @BeforeMethod
    public void setUp(@Optional String kullanilacakBrowser){

        driver= DriverCross.getDriver(kullanilacakBrowser);

    }

    @AfterMethod
    public void tearDown(){

        DriverCross.quitDriver();
    }
}





















