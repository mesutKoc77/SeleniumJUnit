package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class Q1{
    /*..........Exercise1............

    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin

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
        driver.get("http://www.google.com");

    }

    @Test
    public void test1(){
        driver.findElement(By.xpath("(//div[@class=\"QS5gu sy4vM\"])[2]")).click();
        driver.findElement(By.xpath("//input[@jsaction='paste:puy29d;']")).sendKeys("The Lord of the Rings"+ Keys.ENTER);

    }
    @Test
    public void test2(){
        driver.findElement(By.xpath("//input[@jsaction='paste:puy29d;']")).sendKeys("Brave Heart"+ Keys.ENTER);
    }
    @Test
    public void test3(){
        driver.findElement(By.xpath("//input[@jsaction='paste:puy29d;']")).sendKeys("Harry Potter"+ Keys.ENTER);
    }

    @After
    public void after1(){
        String result=driver.findElement(By.id("result-stats")).getText();
        String [] arr=result.split(" ");
        String actualResult =arr[1];
        System.out.println("bulunan sonuc sayıısı : "+actualResult);
    }

    @AfterClass
    public static void teardown(){
      driver.close();
    }

}
