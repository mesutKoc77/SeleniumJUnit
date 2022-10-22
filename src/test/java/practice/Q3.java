package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
     /*
...Exercise4...
https://www.teknosa.com/ adresine gidiniz
arama cubuguna oppo yazip enter diyiniz//
sonuc sayisini yazdiriniz//
cikan ilk urune tiklayiniz//
sepete ekleyiniz//
sepetime git e tiklayiniz
consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
Alisverisi tamamlayiniz
son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
driver i kapatiniz

      */

    WebDriver driver;
    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.teknosa.com/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class=\"js-site-search-input-auto search-input personaclick-instant-search\"]")).sendKeys("oppo"+ Keys.ENTER);
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[@class=\"plp-info\"]")).getText());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title=\"Oppo A74 128 GB Akıllı Telefon Prizma Siyahı (Oppo Türkiye Garantili)\"]")).click();
/*
        WebElement Cartt=driver.findElement(By.xpath("(//button[@data-product-name=\"Oppo A74 128 GB Akıllı Telefon Prizma Siyahı (Oppo Türkiye Garantili)\"])[1]"));
        Cartt.click();

        driver.findElement(By.xpath("(//a[@class='btn btn-secondary'])[1]")).click();
        Thread.sleep(2000);
        System.out.println("Siparis Ozeti : " + driver.findElement(By.xpath("(//div[@class='cart-sum-title'])[1]")).getText());
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='Alışverişi Tamamla'])[1]")).click();
        Thread.sleep(2000);
        System.out.println("Siparis Ozeti : " + driver.findElement(By.xpath("(//div[@class='lrl-title'])[1]")).getText());
        Thread.sleep(2000);

 */
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
