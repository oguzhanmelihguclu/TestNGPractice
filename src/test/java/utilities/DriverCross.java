package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverCross {
    /*
        DriverCross'un bizim kullandigim Driver Class'indan farki :

        Driver Class  : calisacak browser bilgisini ConfigReader araciligi ile
                        configuration.properties'den alir
        DriverCross     ise kullanilacakBrowser'i
                        configuration.properties'den DEGIL
                        parametre olarak TestBaseCross'dan alir
     */

    private static WebDriver driver;
    private DriverCross(){

    }

    public static WebDriver getDriver(String kullanilacakBrowser){


        kullanilacakBrowser =   kullanilacakBrowser==null
                                ?
                                ConfigReader.getProperty("browser")
                                :
                                kullanilacakBrowser ;

        // bu satir bizim emniyet subabimiz
        // eger parametre olarak null gonderilirse
        // configuration.properties'deki browser degerini alacak

        if(driver == null){

            switch (kullanilacakBrowser){
                case "firefox" :
                    driver= new FirefoxDriver();
                    break;
                case "safari" :
                    driver= new SafariDriver();
                    break;

                case "edge" :
                    driver = new EdgeDriver();
                    break;
                default:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-search-engine-choice-screen");
                    driver = new ChromeDriver(options);

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }


    public static void closeDriver(){

        if (driver != null){
            driver.close();
            driver=null;
        }
    }

    public static void quitDriver(){

        if (driver != null){
            driver.quit();
            driver=null;
        }
    }
}
