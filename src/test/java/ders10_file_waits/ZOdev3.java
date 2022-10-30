package ders10_file_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class ZOdev3 extends TestBase {
    /*
    1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a  kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
5."username" ve  "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test edin
     */
    @Test
    public void test02() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/");
        String ilkWindow= driver.getWindowHandle();
        System.out.println("ilkWindowDegeri : "+ilkWindow);
        Actions action=new Actions(driver);
        WebElement move=driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        action.moveToElement(move).perform();
        move.click();

      Set<String> handles=driver.getWindowHandles();
        String ikinciWindow="";
        for (String each:handles
             ) {
            if (!each.equals(ilkWindow)){
               ikinciWindow=each;

            }
            System.out.println(ikinciWindow);
        }

        driver.switchTo().window(ikinciWindow);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Mesut");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("KOC");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
       String actualText=driver.switchTo().alert().getText();
       String expected="validation failed";
        Assert.assertEquals(expected,actualText);

        driver.switchTo().alert().accept();

        driver.switchTo().window(ilkWindow);
       String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://webdriveruniversity.com/";

        Assert.assertEquals(expectedUrl,actualUrl);

    }


}
