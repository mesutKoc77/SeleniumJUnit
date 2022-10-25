package ders09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class zOdev1 extends TestBase {
    /*
    Yeni Class olusturun ActionsClassHomeWork
1- “http://webdriveruniversity.com/Actions” sayfasina gidin
2- Hover over Me First” kutusunun ustune gelin
3- Link 1" e tiklayin
4- Popup mesajini yazdirin
5- Popup’i tamam diyerek kapatin
6- “Click and hold” kutusuna basili tutun
7-“Click and hold” kutusunda cikan yaziyi yazdirin
8- “Double click me” butonunu cift tiklayin
     */

    @Test
    public void test01(){
        driver.get("http://webdriveruniversity.com/Actions");
        WebElement overMeFirstElement=driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(overMeFirstElement).perform();
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();
        System.out.println("theMessageOfPopup: "+driver.switchTo().alert().getText());//theMessageOfPopup: Well done you clicked on the link!
        driver.switchTo().alert().accept();
        actions.clickAndHold(driver.findElement(By.xpath("//div[@id='click-box']"))).perform();
        System.out.println("yazimiz :"+driver.findElement(By.xpath("//div[@id='click-box']")).getText());
         WebElement doubleClickElement=driver.findElement(By.tagName("h2"));
         actions.doubleClick(doubleClickElement).perform();


    }


}
