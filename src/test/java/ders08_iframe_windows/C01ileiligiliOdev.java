package ders08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C01ileiligiliOdev extends TestBase {
       /*
     Bir class olusturun: IframeTest02
     1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
     2) sayfadaki iframe sayısını bulunuz.
     3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
     4) ilk iframe'den çıkıp ana sayfaya dönünüz
     5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/guru99home/");
        /*boolean sonuc =driver.getPageSource().contains("iframe");
        if (sonuc){System.out.println("iframe var");} else {System.out.println("iframe yok");}

         */
        int thenumberOfIframes=driver.findElements(By.tagName("iframe")).size();
        System.out.println(thenumberOfIframes);//9
        driver.switchTo().frame("gdpr-consent-notice");

        WebElement acceptCookies=driver.findElement(By.xpath("//span[text()='Tümünü Kabul Et']"));
        acceptCookies.click();
        driver.switchTo().defaultContent();

        WebElement youtubeFramei= driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/RbSlW8jZFe8\"]"));
        driver.switchTo().frame(youtubeFramei);
        driver.findElement(By.xpath("//button[@class=\"ytp-large-play-button ytp-button ytp-large-play-button-red-bg\"]")).click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("//img[@src=\"Jmeter720.png\"]")).click();
        Thread.sleep(2000);

    }


}

