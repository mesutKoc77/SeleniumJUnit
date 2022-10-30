package ders10_file_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class ZOdev2 extends TestBase {
    /*
 “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
“Our Products” butonuna basin
“Cameras product”i tiklayin
Popup mesajini yazdirin
“close” butonuna basin
"WebdriverUniversity.com (IFrame)" linkini tiklayin
"http://webdriveruniversity.com/index.html" adresine gittigini test edin
     */
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        driver.switchTo().frame(driver.findElement(By.id("frame")));
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement yazi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
        System.out.println(" yaziGeldi :  "+" "+yazi.getText());
        driver.findElement(By.xpath("//*[text()='Close']")).click();

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(expectedUrl,actualUrl);

    }

}
