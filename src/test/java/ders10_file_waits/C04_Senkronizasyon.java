package ders10_file_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;

public class C04_Senkronizasyon {
    /*
    Testlerimizi calıştırıken iğnternet, bilgisayarımızn hızı veya
    çalıştıgımız uygulamadan kaynaklanan gecikmeler olabilir.
    bu durumda testinmizn failed olmaması için çalışma ortamımız (internet, bilgisayar, çalıştırgımız uygulama)
    senkronize etmemiz gerekir.

     */
    /*
    Senkronizasyon problemlerinden java'dan 1, selenium'dan 2 yardimci vardir.

1- Thread.sleep() Java'dan gelir
   ve dinamik degildir.
   yazilan sure kadar kodlarin alt satira gecmesini bekletir.
   Thread.sleep esnek olmadigi icin, gorev degil sure odakli calistigi icin
   testlerin gereksiz yere uzun surmesine sebep olabilir
   Bunun icin de test yazilirken kullanilmasi tercih edilmez
2- implicitlyWait(max.bekleme suresi)
   Selenium'dan gelir
   Dinamiktir, yani gorev odaklidir,
   her adimda max.sure beklemek yerine, gorevin gerceklesecegi sure kadar bekler
   max sure beklemedigi icin fazladan zaman harcanmasinin onune gecer

   implicitlyWait tum class'i kapsar
   tum class'daki herbir locate vb. islem icin dinamik bekleme suresi saglar

   max. bekleme suresi doldugu halde gorev gerceklesmemis olursa
   hata verir.

   implictly wait icin max bekleme suresini ne uzun ne de cok kisa olmasi tercih edilmez
   optimum bir max bekleme suresi belirlenmelidir.

3- Explicitly wait
   Eger test sirasinda yapacagimiz herhangi bir islem icin
   implicitly wait ile belirledigimiz sure yetmiyorsa
   tum testlerdeki implictly wait surelerini artirmak yerine
   sadece o teste ve sadece o isleme ozel bekleme olusturulabilir

   explicitly wait tek bir goreve odaklanmis bekleme suresi olusturur
   explicitly wait de dinamiktir, yani sureye degil, goreve odaklanir
   gorev erken tamamlanirsa, explicitly wait daha fazla beklemeden testin kalanina gecisi saglar


 */

@Test
    public void test01() throws InterruptedException {
    //extends ve imlicitywait olamdan yputube a gidip cookşes i kabul edip ilk video ya tıklayalım

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://www.youtube.com");
    TestBase.bekle(5);
    WebElement esas=driver.findElement(By.xpath("//a[text()='Hizmet Şartları']"));
    Actions actions=new Actions(driver);
    actions.moveToElement(esas).perform();
    Thread.sleep(5000);
    driver.findElement(By.xpath("(//div[@class=\"yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse\"])[1]")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//img[@src=\"https://i.ytimg.com/vi/6ggTmB_mdcg/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDoFPQc57tZZW0L5Veu9cK4uDbwtw\"]")).click();

}
//kalınan 2.01
}
