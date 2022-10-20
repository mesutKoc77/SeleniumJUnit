package ders08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_handleWindows {
    /*7

● Amazon anasayfa adresine gidin.
● Sayfa’nin window handle degerini String bir degiskene atayin
● Sayfa title’nin “Amazon” icerdigini test edin
● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
● Sayfa title’nin “wisequarter” icerdigini test edin
● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
● Sayfa title’nin “Walmart” icerdigini test edin
● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void windowTesti() throws InterruptedException {
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //Sayfa’nin window handle degerini String bir degiskene atayin
        String ilkSayfaninWindowHandlei= driver.getWindowHandle();
        //Sayfa title’nin “Amazon” icerdigini test edin
        String expected="Amazon";
        String actualText=driver.getTitle();
        Assert.assertTrue(actualText.contains(expected));
        //Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        /*
        driver.switchTo().newWindow() method u ile yeni bir sayfa oluşturup driever i o sayfaya switch ederiz.
        yani bu geciş driver uzerınden yapıldıgı için driver yeni sayfaya gecer ve yeni sayfada işlem yapabiliriz.
        bu bir kontrollu geciştir.

         */
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        //● Sayfa title’nin “wisequarter” icerdigini test edin
      expected="wisequarter";
      actualText=driver.getTitle();
      Assert.assertFalse(actualText.contains(expected));

      //  ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");

      //● Sayfa title’nin “Walmart” icerdigini test edin
        expected="Walmart";
        actualText=driver.getTitle();

        Assert.assertTrue(actualText.contains(expected));

      //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        /*
        driver i switch to () ile yeni bir tab veya window a gecirebiliriz.
        yeni window oluştrumak dışında herhangi bir window a gecmenin tek yolu,
        geçmek istedigimiz sayfanın windowhandle degerini kullanmak.

        yani, bir test sırasında yeniden donmeniz gereken bir window da isek,
        o sayfanın window handle degerini kaydetmiliyiz.

         */

      String ilkSayfaninUrlsi=driver.switchTo().window(ilkSayfaninWindowHandlei).getCurrentUrl();
      Thread.sleep(5000);

        System.out.println(ilkSayfaninUrlsi);

        expected="https://www.amazon.com/";
        actualText=ilkSayfaninUrlsi;

        Assert.assertEquals(expected,actualText);

    }




    @After
    public void teardown(){
        driver.quit();
    }



}
