package tests.testNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_PositiveLoginTesti {

    @Test (groups = {"smoke","regression","E2E"})
    public void positiveLoginTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        // 2- account linkine basin

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                            .click();

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys("wise@gmail.com");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys("12345");

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu
                            .click();

        // 6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());


        // logout olun

        testotomasyonuPage.logoutButonu
                .click();
    }


    @Test(groups = {"smoke","regression"})
    public void dinamikPositiveLoginTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        ReusableMethods.bekle(1);
        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                            .click();

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(1);
        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu
                            .click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

        ReusableMethods.bekle(1);
        // logout olun
        testotomasyonuPage.logoutButonu
                            .click();
        Driver.quitDriver();

    }
}
