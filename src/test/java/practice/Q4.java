package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q4 {
     /*
   ...Exercise6...
// 1. Amazon.com'a gidelim.
// 2. DropDown üzerinde Books secelim.(All yazan yerde)
//    kategorilerin hepsini konsola yazdiralim
// 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
// 4. Sonuc sayisini ekrana yazdiralim.
// 5. Sonucların Les Miserables i icerdigini assert edelim
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
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement DDM= driver.findElement(By.xpath("//select[@aria-describedby=\"searchDropdownDescription\"]"));

        Select select=new Select(DDM);
        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());
         List<WebElement> tamami=select.getOptions();

        for ( WebElement each:tamami
             ) {
            System.out.print(each.getText()+"\n");
        }
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Les Miserables"+ Keys.ENTER);
        String result=driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]")).getText();
        System.out.println("the Result for Les Miserables : " +result);
        Assert.assertTrue(result.contains("Les Miserables"));

    }

    @After
    public void tearDown(){
        driver.close();
    }



}
