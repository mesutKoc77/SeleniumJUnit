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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_HandleDDM {
    // amazon anasayfaya gidin
    // arama kutusunun solundaki DDM'deki option sayisinin 27 oldugunu test edin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement DDM=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(DDM);
        List<WebElement> alleOptions=select.getOptions();

        //tum optionların neler oldugunu gorelim

        for (WebElement eachOption:alleOptions
             ) {
           // System.out.print(eachOption.getText()+"\n");
        }
        int quantityofOptions=alleOptions.size();
        //System.out.println(quantityofOptions);//28
        Assert.assertEquals(27,quantityofOptions);
    }



    @After
    public void teardown(){
        driver.close();
    }

}
