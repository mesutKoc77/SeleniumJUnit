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

public class C04_CheckBoxTest {
    // a. Verilen web sayfasına gidin.
    //	     https://the-internet.herokuapp.com/checkboxes
    //	b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //  c. Checkbox1'in secili olmadigini ve
    //     Checkbox2'nin secili oldugunu test edin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if (!checkBox1.isSelected()) {
            System.out.println("checkbox 1 seçili degil TEST PASSED");
        } else {
            System.out.println("checkbox 1 seçili  TEST FAILED");
        }
        if (checkBox2.isSelected()){
            System.out.println("checkbox 2 seçili TEST PASSED");
        }else {
            System.out.println("checkbox 2 seçili degil  TEST FAILED");}
    }


    @After
    public void teardown(){
        driver.close();
    }

}
