package ders09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_FacebookKayit extends TestBase {
    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get(" https://www.facebook.com");

        //2- cookies'i kabul edin ve yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //driver.findElement(By.linkText("Create New Account")).click();
        WebElement nameKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.click(nameKutusu).keyDown(Keys.SHIFT).sendKeys("mesut").keyUp(Keys.SHIFT)
        .sendKeys(Keys.TAB).keyDown(Keys.SHIFT).sendKeys("koc").keyUp(Keys.SHIFT)
        .sendKeys(Keys.TAB).keyDown(Keys.SHIFT).sendKeys("dsfnsd@gmail.com").keyUp(Keys.SHIFT)
        .sendKeys(Keys.TAB).keyDown(Keys.SHIFT).sendKeys("B").keyUp(Keys.SHIFT)
        .sendKeys("enim").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
        .sendKeys("08").sendKeys(Keys.TAB).sendKeys("May")
        .sendKeys(Keys.TAB).sendKeys("1989")
        .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
         .sendKeys(Keys.ARROW_RIGHT)
         .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
         .sendKeys(Keys.ENTER).perform();

        //4- Kaydol tusuna bastik
        bekle(5);

    }
}
