package ders06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButtonTest {
    // https://www.facebook.com adresine gidin
    // Cookies’i kabul edin
    // “Create an Account” button’una basin
    // “radio buttons” elementlerini locate edin
    // size uygun olan cinsiyet button'unun secili oldugunu test edin


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        driver.get("https://www.facebook.com");
        WebElement out=driver.findElement(By.className("_3ixn"));

        driver.findElement(By.xpath("//button[@title='Temel ve isteğe bağlı çerezlere izin ver']")).click();
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        WebElement genderWoman=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement genderMan=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));

        if (genderMan.isSelected()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

    }

    @After
    public void teardown(){
        driver.close();
    }

}
