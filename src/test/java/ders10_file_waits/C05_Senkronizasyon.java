package ders10_file_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C05_Senkronizasyon {

    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //
    //	 Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin

    @Test
    public void inplicitlyWaitTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebElement itsGoneTexyElement=driver.findElement(By.id("message"));
        Assert.assertTrue(itsGoneTexyElement.isDisplayed());
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        WebElement message=driver.findElement(By.id("message"));
        Assert.assertTrue(message.isDisplayed());

    }
    @Test
    public void explicitlyWaitTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        /* WebElement itsGoneTexyElement= driver.findElement(By.id("message"));
        implicitly wait tanımlamadıgımız ve dolayısyla bulması  için sure vermedgimizden hata mesajı verecektir.


        klasik olarak bir web elementini beklemesiiçin öne webelementini locate etmeliyiz ki
        ona göre de onu beklesin.
        burada zaten webelement ortada yok, olmayan bir webelementi bekle de diyemeyiz.
        bu tur problemlerde web elemnt oluşturma, bekleme ve locate bir arada yapılır.

         */

        WebElement itsGoneTexyElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsGoneTexyElement.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        WebElement ItsbackTexti=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(ItsbackTexti.isDisplayed());

    }



}
