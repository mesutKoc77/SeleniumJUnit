package ders09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu ");

        //3- Cizili alan uzerinde sag click yapalim
        WebElement targetField= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(targetField).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String expectedText="You selected a context menu";
        String actualText=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(3000);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String theFirstWindowsHandle=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Thread.sleep(3000);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        // once driver'i 2.sayfaya gecirmeliyiz, bunun icin de 2.sayfanin handle degerini bulmaliyiz

         Set<String> handles=driver.getWindowHandles();
        String theSecondWindowsHandle="";

        for (String eachHandle: handles
             ) {
            if (!eachHandle.equals(theFirstWindowsHandle)){
                theSecondWindowsHandle=eachHandle;
            }
        }
        driver.switchTo().window(theSecondWindowsHandle);

       String expectedTextOfTag="Elemental Selenium";
       String actualTextOfTag=driver.findElement(By.tagName("h1")).getText();
       //System.out.println(actualTextOfTag);//Elemental Selenium
       Thread.sleep(3000);
       Assert.assertEquals(expectedTextOfTag,actualTextOfTag);
       Thread.sleep(5000);

    }


    }



