package tests.TestNGAssertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_CokluAssertion {

    @Test
    public void ilkUrunIsimtesti(){

        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // 2- phone icin arama yapip

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // urun bulunabildigini test edin

        String actualSonuc = testotomasyonuPage.aramaSonucuElementi.getText();
        String unExpectedSonuc = ConfigReader.getProperty("toUnexpectedSonuc");

        Assert.assertNotEquals(actualSonuc,unExpectedSonuc);


        // 3- ilk urunu tiklayip,
        testotomasyonuPage.ilkUrunElementi.click();

        // urun isminde case sensitive olmadan "phone" bulundugunu test edin

        String expectedIsimIcerik = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                                        .getText()
                                        .toLowerCase();


        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        Driver.quitDriver();


    }
}
