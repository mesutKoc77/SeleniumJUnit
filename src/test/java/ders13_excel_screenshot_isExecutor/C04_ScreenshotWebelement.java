package ders13_excel_screenshot_isExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_ScreenshotWebelement extends TestBase {
    @Test
    public void test02() throws IOException {

        driver.get("https://www.amazon.com");
        //nutella için arama yapalım
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonucların nutella içerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualYazi=sonucYaziElementi.getText();
        Assert.assertTrue(actualYazi.contains(expectedKelime));

        //sadece sonuc yazıısı elenmentinin screenshot ını cekelim
        /*
        1. adım: screenshot cekecgımız webelementi locate edelim
        2 3 ve 4. adımlar tumsayfa screenshot ile ayni
         */

        File sonucYazisiSayfa=new File("target//ScreenShot//sonucYazisiSayfaScreenshot.jpeg");//resmi kaydedecgmz dosyayi oluşturduk
        File geciciResim=sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,sonucYazisiSayfa);

    }



}
