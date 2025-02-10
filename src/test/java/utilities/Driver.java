package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver(){
        // Singleton pattern ile bu class'dan obje olusturulabilmesini engellemek icin
        // Constructor'i gorunur yapip, kimsenin erisememesi icin private isaretliyoruz
    }

    public static WebDriver driver;

    public static WebDriver getDriver(){
        /*
            Bu method'u her kullandigimizda new ChromeDriver(); calisinca
            yeni bir browser aciliyor

            Biz sadece ilk defa bu method'u kullandigimizda
            new ChromeDriver(); calissin,
            sonraki kullanimlarda calismasin
            istiyoruz
         */
        /*
            Driver'in her seferinde chrome olmasi yerine
            configuration.properties'de browser key'in degeri ne ise
            browser'in dinamik olarak o deger olmasini istiyoruz

            browser'in dinamik olmasi icin
            once configuration.properties'deki browser degerini alalim
            ve bir switch ile hangi browser istenmis ise
            ona ait bir WebDriver olusturmasini saglayalim
         */


        String calisacakBrowser = ConfigReader.getProperty("browser");

        if (driver == null){

            switch (calisacakBrowser){

                case "safari" :
                    driver = new SafariDriver();
                    break;

                case "edge" :
                    driver = new EdgeDriver();
                    break;

                case "firefox" :
                    driver = new FirefoxDriver();
                    break;

                default:
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }


        return driver;
    }


    public static void quitDriver(){
        driver.quit(); // acik olan browser'lari kapatir
        driver=null; // bu class'daki driver objesine null degeri atayarak
                     // yeni browser acilmasina imkan tanir
    }
}
