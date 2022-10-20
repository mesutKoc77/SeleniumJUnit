package ders08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class C02_handleWindows {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void windowtesti(){
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkSayfawindowHandleDegeri=driver.getWindowHandle();

        // elemental selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();

        /*
        bir linke tıkladıgımızda driver i açılan yeni window a direkt switch edemeyiz.
        önce o sayfanın window handle ini bulmalı ve o window handle degerini kullanrak yenşi sayfaya gecmeliyiz.

        ilk sayfanın ki
        //CDwindow-0B6E659B8703A32C147323AEC7126EE9

      "tumHandle lar : " //[CDwindow-0B6E659B8703A32C147323AEC7126EE9, CDwindow-E8F79BED63C051FB4E580891C16C5E71]

         */
       Set<String> windowHandlesSeti=driver.getWindowHandles();
       String ikinciWindowHandle="";
       //System.out.println("ilk sayfanın ki"+ilkSayfawindowHandleDegeri);//CDwindow-0B6E659B8703A32C147323AEC7126EE9
       // System.out.println("tumHandle lar : "+windowHandlesSeti);//[CDwindow-0B6E659B8703A32C147323AEC7126EE9, CDwindow-E8F79BED63C051FB4E580891C16C5E71]

        for (String each:windowHandlesSeti
             ) {
            if (!each.equals(ilkSayfawindowHandleDegeri)){
                ikinciWindowHandle=each;
            }
        }

        driver.switchTo().window(ikinciWindowHandle);


        // Acilan sayfadaki en bastaki yazinin gorunur oldugunu
        WebElement elementalSellenium=driver.findElement(By.xpath("//h1[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSellenium.isDisplayed());
        // ve yazinin Elemental Selenium oldugunu test edin
        String expectedText="Elemental Selenium";
        String actualText=elementalSellenium.getText();
        Assert.assertEquals(expectedText,actualText);

        /*
        drive.get ile önce "https://the-internet.herokuapp.com/iframe" gittik. ama sonradan başka sayfa ya gittik
        bunun için drive ı oraya yonlendırlmeliyiz.

        dolayısıyla driver i window lar arasında geciş yapmaliyız.

         */

    }

    @After
    public void teardown(){
        driver.quit();
    }



}
