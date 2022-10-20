package ders08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C01_iframe {
    //  ● Bir class olusturun: IframeTest
    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //   ● Bir metod olusturun: iframeTest
    //		○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //		ve  konsolda 	yazdirin.
    //		○ Text Box’a “Merhaba Dunya!” yazin.
    //		○ TextBox’in altinda bulunan “Elemental Selenium”
    //		linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void iframeTest() throws InterruptedException {

        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //		○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
        WebElement text=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(text.isEnabled());
        //		ve  konsolda 	yazdirin.
        System.out.println(text.getText());
        //		○ Text Box’a “Merhaba Dunya!” yazin.
        /*
        ulaşmak istedigimiz bir webelement bit iframe içerisinde ise driver o webelement e direkt ulaşamaz
        bunun için önce webelement in içinde oldugu iframe e geçiş yapmam ız gerekir.

        bir iframe e geciş için o iframe in index nin veya id attribute nun degeri ya da web element olarak locate
        edilen obje olarak bunlardan birisi kullanılabilir.
        switchto().frame() method u kullanilabilir.
         */

        WebElement iframeElementi=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElementi);
        driver.findElement(By.tagName("p")).clear();
        driver.findElement(By.tagName("p")).sendKeys("Merhaba Dunya!");
        Thread.sleep(5000);

        //		○ TextBox’in altinda bulunan “Elemental Selenium”
        //		linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        driver.switchTo().defaultContent();
        WebElement webelementSleenum=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(webelementSleenum.isEnabled());
        System.out.println(webelementSleenum.getText());

        /*
        bri iframe in içinde girdikten sonra asıl sayfa ile ilgili işlem yapmak istersek girdigimiz iframe den çıkıp
        asıl sayfaya griş yapmamız gerekiyor.
        switchto(). defaultContent()---->anasayfaya çıkar
        switch to().parentFrame()-----> içiçe birden fazla frame varsa bu duurmda bir ust iframe e çıkmak için kullanırız

        */
    }

    @After
    public void teardown(){
        driver.close();
    }


}