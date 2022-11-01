package ders13_excel_screenshot_isExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotTumSayfa extends TestBase {
    @Test
    public void test02() throws IOException {
        //amazon a gidelim
        driver.get("https://www.amazon.com");
        //nutella için arama yapalım
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonucların nutella içerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualYazi=sonucYaziElementi.getText();
        Assert.assertTrue(actualYazi.contains(expectedKelime));
        //tum sayfanin screenschot ını almak için 4 adım vardır:

       //1-  - takesScreenShot objesi oluşturup,
       // - deger olarak cast ettiğimiz driver i atayalım

        TakesScreenshot tss=(TakesScreenshot) driver;

        //2- resmi kaydedecigimiz bir dosya oluşturulur

        File tumSayfaSShot=new File("target//ScreenShot//tumSayfaScreenshot.jpeg");

        //3- screenshot objesi kullarank ffoto çekip gecici dosyaya kaydedelim

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayı hazırladdıgımız file a kopyalayalım

        FileUtils.copyFile(geciciResim,tumSayfaSShot);

    }

}
