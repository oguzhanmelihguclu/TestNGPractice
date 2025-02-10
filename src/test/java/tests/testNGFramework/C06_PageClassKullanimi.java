package tests.testNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C06_PageClassKullanimi {

    // 3 farkli test methodu olusturup, asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin

    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Test(groups = "smoke")
    public void anasayfaTesti(){
        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test(dependsOnMethods = "anasayfaTesti",groups = {"smoke","regression"})
    public void phoneAramaTesti(){
        // 2- phone icin arama yapip

        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // urun bulunabildigini test edin

        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = testotomasyonuPage.aramaSonucuElementi.getText();

        Assert.assertNotEquals(actualSonuc,unExpectedSonuc);

    }

    @Test(dependsOnMethods = "phoneAramaTesti",groups = {"smoke","E2E"})
    public void ilkUrunIsimTesti(){
        // 3- ilk urunu tiklayip,
        testotomasyonuPage.ilkUrunElementi
                            .click();

        // urun isminde case sensitive olmadan "phone" bulundugunu test edin

        String expectedIsimIcerik = "phone";

        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                                                    .getText()
                                                    .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        Driver.quitDriver();
    }
}
