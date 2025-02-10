package tests.CrossBrowserCalistirilacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_NegativeLoginTesti extends TestBaseCross {


    @Test
    public void gecersizPasswordTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

        //2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();
        ReusableMethods.bekle(1);

        // 3-  3 farkli test method’u olusturun.
        //	- gecerli email, gecersiz password
        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin

        driver.findElement(By.id("submitlogin"))
                .click();

        //5- Basarili olarak giris yapilamadigini test edin
        emailKutusu = driver.findElement(By.id("email"));
        Assert.assertTrue(emailKutusu.isDisplayed());


    }

    @Test
    public void gecersizEmailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

        //2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();
        ReusableMethods.bekle(1);


        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecerli password
        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));


        //4- Login butonuna basarak login olmayi deneyin

        driver.findElement(By.id("submitlogin"))
                .click();
        ReusableMethods.bekle(1);
        //5- Basarili olarak giris yapilamadigini test edin
        emailKutusu = driver.findElement(By.id("email"));
        Assert.assertTrue(emailKutusu.isDisplayed());
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

        //2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();
        ReusableMethods.bekle(1);

        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecersiz password.
        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));


        //4- Login butonuna basarak login olmayi deneyin

        driver.findElement(By.id("submitlogin"))
                .click();
        ReusableMethods.bekle(1);

        //5- Basarili olarak giris yapilamadigini test edin
        emailKutusu = driver.findElement(By.id("email"));
        Assert.assertTrue(emailKutusu.isDisplayed());

    }
}
