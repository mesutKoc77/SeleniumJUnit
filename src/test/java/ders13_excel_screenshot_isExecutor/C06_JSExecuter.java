package ders13_excel_screenshot_isExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C06_JSExecuter extends TestBase {

    @Test
    public void test01(){
        //javascript ile ilgili bilgileri internneten bulabilrisn
        //javascriptexecutor selenium google a yaz


        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // sell butonuna Js executor ile basalim

        WebElement sellLinki= driver.findElement(By.xpath("//a[text()='Sell']"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",sellLinki);

        // bir alert olusturup yasasinnn yazdiralim

        jse.executeScript("alert('yasasinnnn');");

        bekle(5);

        driver.switchTo().alert().accept();

        //bazi seyleri javascriptexecutor ile yapabiliriz eger şimdiye kadar ogrendiklerimizle yapamıyorsak.
    }

    }


