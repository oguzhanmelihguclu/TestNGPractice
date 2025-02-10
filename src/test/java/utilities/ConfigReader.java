package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
        Bu class'in 2 temel gorevi var
        1- configuration.properties dosyasindaki bilgileri okumak
           ConfigReader calistirildiginda ONCELIKLE bu okuma isleminin yapilmasi icin
           okuma islemini bir static blok icerisinde yapiyoruz

           static blok calistiginda
           configuration.properties dosyasindaki tum key - value ikililerini okuyup
           class level'da bulunan "properties" objesine yukluyor

        2- ilk gorevde configuration.properties dosyasindaki
           tum key - value ikilileri okunup properties objesine yuklendi

           getProperty(istenenKey) method'u ise
           properties objesine yuklenen key-value'lerden
           bizim verecegimiz key'in karsiligindaki value'yu alip
           test method'una dondurur
     */

    static Properties properties; // configuration.properties'deki tum key-value'ler yuklendi

    static {// static blok herseyden once calisir

        String dosyaYolu= "configuration.properties";
        try {

            FileInputStream fis= new FileInputStream(dosyaYolu);
            properties= new Properties();
            properties.load(fis);


        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");
        }
    }

    public static String getProperty(String key){

        return properties.getProperty(key);

    }


}
