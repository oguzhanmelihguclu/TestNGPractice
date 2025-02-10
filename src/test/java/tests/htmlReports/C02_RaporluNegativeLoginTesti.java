package tests.htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluNegativeLoginTesti extends TestBaseRapor {

    static TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Test(groups = "smoke")
    public void gecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz Password testi",
                "Kullanici gecerli email ve gecersiz password ile giris yapamamali");
        testotomasyonuPage = new TestotomasyonuPage();

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici test otomasyonu anasayfaya gider");

        //2- account linkine basin
        testotomasyonuPage.accountLinki
                .click();
        extentTest.info("account linkine basar");
        // 3-  3 farkli test method’u olusturun.
        //	- gecerli email, gecersiz password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("email kutusuna gecerli email girer");
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("password kutusuna gecersiz password girer");

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        extentTest.info("sayfayi kapatir");
    }

    @Test
    public void gecersizEmailTesti(){
        testotomasyonuPage = new TestotomasyonuPage();
        extentTest = extentReports.createTest("Gecersiz Email testi",
                "Kullanici gecersiz email ve gecerli password ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici test otomasyonu anasayfaya gider");

        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecerli password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("email kutusuna gecersiz email girer");

        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("password kutusuna gecerli password girer");

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        extentTest.info("sayfayi kapatir");
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        testotomasyonuPage = new TestotomasyonuPage();

        extentTest = extentReports.createTest("Gecersiz Email ve Gecersiz Password testi",
                "Kullanici gecersiz email ve gecersiz password ile giris yapamamali");


        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici test otomasyonu anasayfaya gider");

        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecersiz password.
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("email kutusuna gecersiz email girer");

        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("password kutusuna gecersiz password girer");

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        extentTest.info("sayfayi kapatir");

    }
}
