package tests.htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProviderIleTopluAramaTesti {



    @DataProvider
    public static Object[][] UrunProvideri() {
        //Data provider must return Object[][]

        String[][] urunlerArrayi = {{"phone"}, {"java"}, {"dress"}, {"baby"}, {"nutella"},
                                    {"samsung"}, {"iphone"}, {"shirt"} };

        return urunlerArrayi;
    }


    @Test(dataProvider = "UrunProvideri")
    public void aramaTesti( String aranacakUrun){

        // testotomasyonu sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        // arama kutusuna aranacakUrun'u yazdirip enter'a basin

        testotomasyonuPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        String unexpectedAramaSonucu = ConfigReader.getProperty("toUnexpectedSonuc");
        String actualAramaSonucYazisi = testotomasyonuPage.aramaSonucuElementi.getText();

        Assert.assertNotEquals(actualAramaSonucYazisi,unexpectedAramaSonucu,aranacakUrun+" bulunamadi" );

        Driver.quitDriver();
    }
}
