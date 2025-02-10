package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebDriverUniversityPage {

    public WebDriverUniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[.='LOGIN PORTAL']")
    public WebElement loginPortalElementi;

    @FindBy(xpath = "//input[@id='text']")
    public WebElement usernameKutusu;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[@id='login-button']")
    public WebElement loginButonu;
}
