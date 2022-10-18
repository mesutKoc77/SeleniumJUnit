package ders07_handleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BasicAuthentication {
    /*
    1- Bir class olusturun : BasicAuthentication
2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
 Html komutu : https://username:password@URL
 Username    : admin
  password     : admin
4- Basarili sekilde sayfaya girildigini dogrulayin
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void BasicAuthenticationTesti(){

        //driver.get("https://the-internet.herokuapp.com/basic_auth");
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");//buna endPoint deniliyor ve buna
        //ihtiyacımız var siteye giriş için
        String actualYazi=driver.findElement(By.tagName("p")).getText();
        String expectedYazi="Congratulations";
        Assert.assertTrue(actualYazi.contains(expectedYazi));

    }

    @After
    public void teardown(){
        driver.close();

    }




}
