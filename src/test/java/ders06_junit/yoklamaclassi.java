package ders06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class yoklamaclassi {

    @Test
    public void yoklama2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSd5_I3e-wir0s68TFyY3Cj3Th4vjusJ4xv1aUET0Y4i-sY9cQ/viewform");
        driver.findElement(By.xpath("(//input[@jsname=\"YPqjbf\"])[1]")).sendKeys("Mesut KOÇ");
        driver.findElement(By.xpath("(//input[@jsname=\"YPqjbf\"])[2]")).sendKeys("mkoc1367@gmail.com");
        driver.findElement(By.xpath("(//div[@class=\"AB7Lab Id5V1\"])[1]")).click();
        driver.findElement(By.xpath("(//span[@class=\"NPEfkd RveJvd snByac\"])[2]")).click();
        String wishToSee="Yanıtınız kaydedildi.";
        Assert.assertTrue(driver.getPageSource().contains(wishToSee));
        Thread.sleep(2000);
        driver.close();

    }
}
