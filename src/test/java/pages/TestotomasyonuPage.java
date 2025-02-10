package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuPage {
    /*
        Page class'larinda locate yapabilmesi icin
        WebDriver objemizi bu class'a tanitmamiz gerekiyor

        Bu tanitma islemini yapmak icin constructor ici tercih edilmis
        bu islemin sebebi,
        Test class'larindan page class'ina ulasmak icin
        obje olusturma yontemini kullanmamizdir
        Test class'inda page class'indan obje olusturmak icin
        constructor calistiginda, constructor icine koydugumuz
        initElements() calisir ve page class'ina WebDriver objemizi tanitir

        Bir page class'i olusturdugumuzda
        ILK YAPILMASI GEREKEN ISLEM
        constructor'i gorunur hale getirip
        icerisinde initElements() method'u ile WebDriver'i tanitmak olacaktir.
     */

    public TestotomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement aramaSonucuElementi;


    @FindBy(xpath = "(//*[@class='prod-img'])[1]")
    public WebElement ilkUrunElementi;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindakiIsimElementi;

    @FindBy(xpath = "(//span[.='Account'])[1]")
    public WebElement accountLinki;

    @FindBy(id = "email")
    public WebElement emailKutusu;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id = "submitlogin")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutButonu;






}
