package ders06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass {
    // amazon sayfasina gidin
    // uc ayri test method'u olusturup
    // Nutella, java ve Selenium icin arama yapip, arama sonuclarini yazdirin

    /*
    @BeforeClass ve @AfterClass notasyonalrının methodları StATİC OLMAK  zorundadır.
    JUnit test methodlarını rastgele bir sıra çalıştırır biz bılemeyiz onceden neyi çalıştıracagını.
    Test methodlarını yazarken tamaminin bagımsız olarak da çalıştrılabilecegını goz oununda bulundurmalıyız.


     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void nutellaTest(){
        driver.get("https://www.amazon.com");
        WebElement searchKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        searchKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramaSonucElementi=driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        System.out.println(aramaSonucElementi.getText());
    }

    //dikkat bir webelement i locate ederken class name kullanmak istiyor ve class name in value sunda
    //boşluklar varsa tehlikeli olabilir ve bunun için xpath daha mantıklı olabilir.

    @Test
    public void testJava(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+Keys.ENTER);
        WebElement aramaSonucElementi2= driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        System.out.println(aramaSonucElementi2.getText());

    }

    @Test
    public void testSelenium(   ){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium"+Keys.ENTER);
        WebElement aramaSonucElementi2= driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        System.out.println(aramaSonucElementi2.getText());

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }


}
