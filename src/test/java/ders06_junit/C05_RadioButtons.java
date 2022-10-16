package ders06_junit;

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

public class C05_RadioButtons {
    // 1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //https://www.facebook.com adresine gidin
    //Cookies’i kabul edin
    //“Create an Account” button’una basin
    //“radio buttons” elementlerini locate edin
    //Secili degilse cinsiyet butonundan size uygun olani secin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement out=driver.findElement(By.className("_3ixn"));

        driver.findElement(By.xpath("//button[@title='Temel ve isteğe bağlı çerezlere izin ver']")).click();
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        WebElement genderWoman=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement genderMan=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        if (!genderMan.isSelected()){
            genderMan.click();
        }
    Thread.sleep(5000);
    }

    @After
    public void teardown(){
        driver.close();
    }


}
