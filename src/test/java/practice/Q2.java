package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q2 {
    /*
    // 1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin
    // farkli test method’lari olusturarak asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Before
    public void before(){
        driver.get("https://www.bestbuy.com/ ");

    }

    @Test
    public void testOfUrl(){
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void testOfTitle(){
        String actualTitle=driver.getTitle();
        String expectedTitkle="Rest";
        Assert.assertFalse(actualTitle.contains(expectedTitkle));

        //ya da kest içeriyor mu?

        boolean iceriyorMu=driver.getTitle().contains("kest");
        //System.out.println(iceriyorMu);//false
        Assert.assertFalse("boolean ile denedik : ",iceriyorMu);

    }
    @Test
    public void testOfLogo(){
      WebElement elementOfLogo=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
      Assert.assertTrue(elementOfLogo.isDisplayed());

       //relative locator ile bulalım

      WebElement helloText=driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
      WebElement bestbuylogo=driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloText));
      Assert.assertTrue(bestbuylogo.isDisplayed());

    }

    @Test
    public void testOfLink(){
      WebElement elementOfLink=driver.findElement(By.xpath("//button[text()='Français']"));
      Assert.assertTrue(elementOfLink.isDisplayed());

       //bunu da relative locator ile yapalım

        WebElement espanol=driver.findElement(By.xpath("//button[@lang='es']"));
        WebElement francais=driver.findElement(RelativeLocator.with(By.tagName("button")).near(espanol));
        Assert.assertTrue(francais.isDisplayed());
    }

    @AfterClass
    public static void afterClass(){
        driver.close();
    }

}
