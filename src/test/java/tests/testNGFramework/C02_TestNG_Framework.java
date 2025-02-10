package tests.testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_TestNG_Framework {



    @Test
    public void driverClassIlkTest(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        // Arama kutusunu locate edip
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        // phone icin arama yapin
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }

}


