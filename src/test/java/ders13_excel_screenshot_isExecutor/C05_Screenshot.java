package ders13_excel_screenshot_isExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_Screenshot extends TestBase {
    @Test
    public void test01() throws IOException {
        //amazon a gidelim
        driver.get("https://www.amazon.com");
        //tum sayfanın fotosunu cekelim
       tumSayfaResimCek();
        //arama kutusuna nutella yazalım fotosunu cekelim
     WebElement kismiNutella=driver.findElement(By.id("twotabsearchtextbox"));
     kismiNutella.sendKeys("Nutella");
        webelementScreenShotCek(kismiNutella);
        kismiNutella.submit();
        //arama yapıp sonucun nutella içerdigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
        //sonuc yazsının fotografını cekin
        webelementScreenShotCek(sonucYaziElementi);


    }
}
