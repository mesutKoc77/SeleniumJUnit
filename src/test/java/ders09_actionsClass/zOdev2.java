package ders09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class zOdev2 extends TestBase {

    /*
      /*
    1- Bir Class olusturalim KeyboardActions2
    2- https://html.com/tags/iframe/ sayfasina gidelim
    3- video'yu gorecek kadar asagi inin
    4- videoyu izlemek icin Play tusuna basin
    5- videoyu calistirdiginizi test edin
     */

    @Test
    public void test02(){
        driver.get("https://html.com/tags/iframe/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']")));
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"ytp-cued-thumbnail-overlay-image\"]"))).perform();
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        WebElement isVideoActiv= driver.findElement(By.xpath("//div[@class=\"html5-video-container\"]"));
        Assert.assertTrue(isVideoActiv.isEnabled());
        driver.switchTo().defaultContent();

    }

}




