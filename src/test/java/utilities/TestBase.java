package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.*;

public class TestBase {
    protected static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
   public void teardown(){

       //driver.close();
    }



    public static void bekle(int beklenecekSure){
        try {
            Thread.sleep(beklenecekSure*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void tumSayfaResimCek() throws IOException {

        //1-  - takesScreenShot objesi oluşturup,
        // - deger olarak cast ettiğimiz driver i atayalım

        TakesScreenshot tss=(TakesScreenshot) driver;

        //2- resmi kaydedecigimiz bir dosya oluşturulur
        //resim ismilerini dinamik yapmak ve resmin tarihini eklmek için
        //resim dosya yoluna tarih ekleyelim

        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");

        File tumSayfaSShot=new File("target//ScreenShot//tumSayfaScreenshot"+ldt.format(dtf)+".jpeg");

        //3- screenshot objesi kullarank foto çekip gecici dosyaya kaydedelim

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayı hazırladdıgımız file a kopyalayalım

        FileUtils.copyFile(geciciResim,tumSayfaSShot);
    }
    public void webelementScreenShotCek(WebElement target) throws IOException {

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");

        File webelementKayitDosyasi=new File("target//ScreenShot//"+"webelementScreenshot"+ldt.format(dtf)+".jpeg");
        File geciciResim=target.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,webelementKayitDosyasi);

    }
}
