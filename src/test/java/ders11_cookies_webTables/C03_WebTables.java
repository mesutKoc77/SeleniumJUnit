package ders11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void amazonTesti(){
        //amazon a gidin
        //analttaki webtable dan homeservice secengını tıklayın
        //ilgili sayfaya gttgini test edin
        driver.get("http://www.amazon.com");
        driver.findElement(By.xpath("//table//tbody//tr[3]//td[5]")).click();
        WebElement isInPage=driver.findElement(By.xpath("//a[@aria-label='Home services appointments during COVID-19']"));
        Assert.assertTrue(isInPage.isDisplayed());

        bekle(5);

        //locate ederken tek slash ilgili elementin hemen altını gosterir
        //çift slash ise ilgili elementin child inin child ini gösterir.

        //tum tablo body sinde care kelimesi gecmedigini test edin

        WebElement tableBody= driver.findElement(By.xpath("//table//tbody"));

        System.out.println(tableBody.getText());

        Assert.assertFalse(tableBody.getText().contains("care"));

    }

}
