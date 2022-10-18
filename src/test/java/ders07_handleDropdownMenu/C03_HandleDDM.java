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
import java.util.List;

public class C03_HandleDDM {
    // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	4.Tüm dropdown değerleri(value) yazdırın
    //	5. Dropdown’un boyutunun 3 oldugunu test edin

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
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement DDM=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(DDM);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        select.selectByValue("2");
        System.out.println("value gore : "+select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        List<WebElement> options=select.getOptions();

        for (WebElement eachElement:options
             ) {
            System.out.println(eachElement.getText());
        }
        int theActualSizeOfOptions=options.size();
        int theExpectedSizeofOptions=3;

        Assert.assertEquals(3,theActualSizeOfOptions);


    }




    @After
    public void teardown(){
       driver.close();
    }








}
