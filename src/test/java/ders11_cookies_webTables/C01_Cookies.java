package ders11_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.youtube.com");
        bekle(5);
        WebElement esas=driver.findElement(By.xpath("//a[text()='Hizmet Şartları']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(esas).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[@class=\"yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse\"])[1]")).click();
        Thread.sleep(5000);

        Set<Cookie> cookieSet=driver.manage().getCookies();

        for (Cookie each:cookieSet
             ) {
            System.out.println(each);
        }
        System.out.println("===============================");

        Cookie cookie=new Cookie("enguzel", "bizim cookie");
        driver.manage().addCookie(cookie);
        Set<Cookie> cookieSet2=driver.manage().getCookies();
        for (Cookie each:cookieSet2
        ) {
            System.out.println(each);
        }

        bekle(5);




    }



}
