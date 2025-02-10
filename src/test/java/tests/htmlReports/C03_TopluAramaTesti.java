package tests.htmlReports;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_TopluAramaTesti {

    @Test
    public void topluAramaTesti(){

        // testotomasyonu sayfasina gidin
        // verilen urunlerin herbiri icin arama yaptirip
        // arama sonucunda urun bulunabildigini test edin

        // phone, java, dress, baby, nutella, samsung, iphone, shirt

        List<String> aranacakUrunlerList = new ArrayList<>(Arrays.asList("phone", "java", "dress", "baby", "nutella", "samsung", "iphone", "shirt"));

        // testotomasyonu sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        SoftAssert softAssert = new SoftAssert();

        for (String eachUrun :aranacakUrunlerList){

            testotomasyonuPage.aramaKutusu.sendKeys(eachUrun + Keys.ENTER);

            String unexpectedAramaSonucu = ConfigReader.getProperty("toUnexpectedSonuc");
            String actualAramaSonucYazisi = testotomasyonuPage.aramaSonucuElementi.getText();

            softAssert.assertNotEquals(actualAramaSonucYazisi,unexpectedAramaSonucu,eachUrun+" bulunamadi" );

        }

        softAssert.assertAll();


     }
}
