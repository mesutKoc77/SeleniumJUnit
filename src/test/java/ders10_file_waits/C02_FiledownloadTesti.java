package ders10_file_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FiledownloadTesti extends TestBase {

    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. logo.jpg dosyasını indirelim
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
    // String dosyaYolu= "/Users/ahmetbulutluoz/Downloads/logo.png";

@Test
    public void test01(){
    driver.get("https://the-internet.herokuapp.com/download");
    driver.findElement(By.xpath("//*[text()='logo.jpg']")).click();
    bekle(10);
    //C:\Users\mesut\Downloads burada aslında inen dosya

    String dosyaYolu=System.getProperty("user.home")+"//Downloads//logo.jpg";
    Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

}





}
