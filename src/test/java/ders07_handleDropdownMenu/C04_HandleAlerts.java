package ders07_handleDropdownMenu;

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

public class C04_HandleAlerts {
    /*
      Otomasyon sirasinda karsimiza iki tur alert cikar
      1- HTML alerts :
         diger HTML elementleri gibi locate edilebilir
         otomasyonda kullanilabilir
      2- javaScript alerts
         HTML kodlarla locate edilemez
         dolayisla da click, getText gibi method'lar calismaz

       javaScript alert'ler icin tek yontemimiz vardir
       switchTo( ) kullanarak allert'e gecmekl
       ve alert'un izin verdigi islevleri yapmak

    /*
    /*


● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
 ○ 1. butona tıklayın,
 alert deki OK butonuna tıklayın ve
 result mesajının “You successfully clicked an alert”
 oldugunu test edin.


● Bir metod olusturun: dismissAlert
 ○ 2. butona tıklayın,
 uyarıdaki Cancel butonuna tıklayın ve
 result mesajının    “successfuly”

 icermedigini test edin.


● Bir metod olusturun: sendKeysAlert
 ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
 OK butonuna  tıklayın ve
 result mesajında isminizin görüntülendiğini doğrulayın.

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
    public void alertTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement theFirstButton=driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        theFirstButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        WebElement resuult=driver.findElement(By.id("result"));
        String actualText=resuult.getText();
        String expectedText="You successfully clicked an alert";
        Assert.assertEquals(expectedText,actualText);

    }

    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement theSecondButton=driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
        theSecondButton.click();
        driver.switchTo().alert().dismiss();
        String unexpectedText="successfuly";
        String actualText=driver.findElement(By.xpath("//p[text()='You clicked: Cancel']")).getText();
        //System.out.println(actualText);

        Assert.assertFalse(actualText.contains(unexpectedText));

    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        String wordedText="Mesut KOC";
        driver.switchTo().alert().sendKeys(wordedText);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String actualText=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Thread.sleep(2000);
        Assert.assertTrue(actualText.contains(wordedText));

    }









    @After
    public void teardown(){
        driver.close();
    }




}
