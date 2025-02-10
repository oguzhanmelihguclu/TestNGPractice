package tests.htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluPositiveLoginTesti extends TestBaseRapor {


    @Test
    public void raporluPositiveLoginTesti(){
        extentTest = extentReports.createTest("Positive Login Testi","Gecerli bilgilerle sisteme giris yapilabilmeli");

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        ReusableMethods.bekle(1);
        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                .click();
        extentTest.info("account linkine basar");
        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");
        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli password girer");
        ReusableMethods.bekle(1);
        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu
                .click();
        extentTest.info("Login butonuna basarak login olur");
        // 6- Basarili olarak giris yapilabildigini test edin
        ReusableMethods.bekle(1);
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");

        ReusableMethods.bekle(1);
        // logout olun
        testotomasyonuPage.logoutButonu
                .click();
        extentTest.info("Logout butonuna basarak cikis yapar");

        extentTest.info("sayfayi kapatir");
    }
}
