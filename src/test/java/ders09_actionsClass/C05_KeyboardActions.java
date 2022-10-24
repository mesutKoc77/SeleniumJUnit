package ders09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    /*
    klvayede her bir tuşla ilgili temelde iki fonksiyon vardır.
    1- tek seferlik basarsın
    sendKeys(Keys.ENTER)
    2- uzunsureli basmak ve işimiz bitince tustan elimizi kaldırmak

    -basmak için keyDown()
    -basılı olanı bırakmak içinde keyUp()
     */
    @Test
    public void test01(){
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        bekle(2);
        // arama kutusuna actions class'ini kullanarak SamsungA71 yazdirin
        Actions actions=new Actions(driver);
        actions.click(aramaKutusu).keyDown(Keys.SHIFT).sendKeys("s")
                .keyUp(Keys.SHIFT).sendKeys("amsung")
                .keyDown(Keys.SHIFT).sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71").sendKeys(Keys.ENTER)
                .perform();
    }

}
