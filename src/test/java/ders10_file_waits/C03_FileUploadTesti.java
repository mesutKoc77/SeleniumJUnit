package ders10_file_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {
    @Test
    public void uploadTesti(){

            //Tests packagenin altina bir class oluşturun : C05_UploadFile
            //https://the-internet.herokuapp.com/upload adresine gidelim
            driver.get("https://the-internet.herokuapp.com/upload");
            //chooseFile butonuna basalim
            //Yuklemek istediginiz dosyayi secelim.
            WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));

            /*
            dosya sec butonuna bastıktan sonra selenıum ile bilgisayrdan dosya eklmek mumkun degildir.
            onun yerine
            dosyaSecButonu.sendKeys("DosyaYolu") yapılırsa
            dosyasecme işlemi tamamlanmış olur.
            */

            String denemeTextininYolu=System.getProperty("user.home")+"//Desktop//fileTesti//deneme.txt";
            dosyaSecButonu.sendKeys(denemeTextininYolu);
            bekle(10);
             //Upload butonuna basalim.
            WebElement uploadButonu=driver.findElement(By.id("file-submit"));
            uploadButonu.click();
            bekle(2);
            //“File Uploaded!” textinin goruntulendigini test edelim.
            WebElement text=driver.findElement(By.tagName("h3"));
            Assert.assertTrue(text.isDisplayed());

    }

}
