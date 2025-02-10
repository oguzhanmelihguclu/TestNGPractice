package tests.testNGFramework_assertions;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_FacebookTesti {

    @Test
    public void negatifLoginTesti(){
        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        //2- Cookies cikiyorsa kabul edin
        Driver.getDriver().findElement(By.xpath("(//span[ text()='Allow all cookies'])[2]"))
                .click();

        //3- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        //4- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin

        FacebookPage facebookPage = new FacebookPage();
        Faker faker = new Faker();

        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());

        facebookPage.passwordKutusu.sendKeys(faker.internet().password());

        facebookPage.loginButonu.click();

        //5- Basarili giris yapilamadigini test edin

        Assert.assertTrue(facebookPage.loginButonu.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.quitDriver();


    }
}
