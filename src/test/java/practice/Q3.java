package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

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
consol da "Sipariş Özeti" webelementinin text ini yazidiriniz//
Alisverisi tamamlayiniz
son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
driver i kapatiniz

      */

   static WebDriver driver;
    @BeforeClass
    public static void setup() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Before
    public void beforeTest(){
        driver.get("https://www.teknosa.com/");
    }

    @Test
    public void test() throws InterruptedException {
     WebElement searchBox=driver.findElement(By.xpath("//input[@class=\"js-site-search-input-auto search-input personaclick-instant-search\"]"));
        Thread.sleep(2000);
     searchBox.sendKeys("oppo"+Keys.ENTER);
        Thread.sleep(2000);
     System.out.println(driver.findElement(By.xpath("//div[@class=\"plp-info\"]")).getText());
        Thread.sleep(2000);
    driver.findElement(By.xpath("(//a[@class=\"prd-link\"])[1]")).click();

    Thread.sleep(5000);
    driver.navigate().refresh();
    //sayfayı aşağıya kaydırmak için page down için
    //JavascriptExecutor js = (JavascriptExecutor) driver;
    //js.executeScript("window.scrollBy(0,350)", "");
    WebElement esasAlinan=driver.findElement(By.id("ratings-summary"));
    esasAlinan.sendKeys(Keys.PAGE_DOWN);
    driver.findElement(By.xpath("(//button[@id=\"addToCartButton\"])[1]")).click();
    driver.findElement(By.xpath("//a[@class=\"btn btn-secondary\"]")).click();
    System.out.println(driver.findElement(By.xpath("//div[text()='Sipariş Özeti']")).getText());

    WebElement relative=driver.findElement(By.xpath("//span[text()='Toplam']"));
    driver.findElement(RelativeLocator.with(By.xpath("//span[text()='Alışverişi Tamamla']")).below(relative)).click();
   WebElement esas2=driver.findElement(By.xpath("//img[@src=\"https://img-teknosa-sap.mncdn.com/_ui/responsive/theme-teknosa/assets/images/logo.svg\"]"));
        System.out.println(driver.findElement(RelativeLocator.with(By.xpath("//div[@class=\"lrp-title\"]")).below(esas2)).getText());
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

}
