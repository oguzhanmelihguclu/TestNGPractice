package tests.testNGFramework_assertions;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DropdownTesti {

    @Test(groups = "smoke")
    public void dropdownTesti(){
        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");

        TestotomasyonuFormPage testotomasyonuFormPage = new TestotomasyonuFormPage();

        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        Select selectGun = new Select(testotomasyonuFormPage.gunDdm);
        selectGun.selectByIndex(5);

        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy = new Select(testotomasyonuFormPage.ayDdm);
        selectAy.selectByValue("nisan");

        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(testotomasyonuFormPage.yilDdm);
        selectYil.selectByVisibleText("1990");

        //5- Secilen değerleri konsolda yazdirin
        System.out.println(
                selectGun.getFirstSelectedOption().getText()+ " " +
                selectAy.getFirstSelectedOption().getText() + " " +
                selectYil.getFirstSelectedOption().getText()
        );


        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın

        System.out.println(ReusableMethods.stringListeyeDonustur(selectAy.getOptions()));

        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedBoyut = 13;
        int actualBoyut = selectAy.getOptions().size();

        Assert.assertEquals(actualBoyut,expectedBoyut);


        Driver.quitDriver();
    }
}
