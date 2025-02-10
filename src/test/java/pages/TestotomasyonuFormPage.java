package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuFormPage {

    public TestotomasyonuFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//select[@class='form-control'])[1]")
    public WebElement gunDdm;

    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    public WebElement ayDdm;

    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    public WebElement yilDdm;


}
