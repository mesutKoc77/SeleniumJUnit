package ders07_handleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_HandleDropdownMenu {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    /*

    drob down menuşer ozel web element lerdir ve select tag i ile oluştururlurlar.
   1- once dropdown ı locate etmeliyiz
   2- dropdown menulerden option ssecebilmek için sleect class ından obje oluşturulmadılır.
   bu obje ye handle etmek istedigimiz dropdown ı parametre olarak girmeliyiz.
   3- locate ettigimiz ve select objesi oluşturdgumzu menuden option secebilmek için
   -index
   -value
   -visible text
   ile istedigimiz option ı seçebşiliriz.


     */

    @Test
    public void dropdownTest(){
        //amazona gidin
        //amazon kututsnun solundaki search in menusunden Electronics i secelim
        //arama cubuguna java yazıp aratın
        //bulunan sonuc sayısının 1000 den fazla oldugunu test edin

        driver.get("https://www.amazon.com");
        WebElement dropdownElement=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropdownElement);
        select.selectByVisibleText("Electronics");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);
       WebElement result=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
      //  System.out.println(result.getText());//1-24 of 280 results for "Java"
        String [] arr=result.getText().split(" ",4);
      // System.out.println(Arrays.toString(arr));//[1-24, of, 74, results for "Java"]
      //  System.out.println(arr[2]);//74
        int comparingOfResult=Integer.parseInt(arr[2]);//int 74
       // Assert.assertTrue(comparingOfResult>1000);



    }

    @After
    public void teardown(){
        driver.close();
    }


}
