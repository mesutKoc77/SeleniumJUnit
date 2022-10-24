package ders09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_MouseActions extends TestBase {


    @Test public void test01() throws InterruptedException {
        //amazona  a git account and list ten create a list linkini yıklayın
        driver.get("https://www.amazon.com");
       // driver.findElement(By.xpath("//span[text()='Create a List']")).click();

        //sayfanın en alttaki usd dollara  tıkla

        //driver.findElement(By.xpath("//*[text()='USD - U.S. Dollar']")).click();
        //Thread.sleep(3000);

        /*
        bir test gerçekleşitrirken mouse veya klavye ile extra iş yapılabilir.
        create list linkine tıklayabilmke için accoyunt a list in uzerinde beklemek gerekir.
        driver genellikle (web developerların kullandıklarına göre degişebilir)  görebildigi web elementleri kullana
        bilir.

        Selenium mouse ve klavye ille yyapabilecegımız tum fonksıyonları gerçekleştirebilmek için
        Action Class ini ooluşturmuştur.

         */

        //action class ını kullanabilmek için obje oluşturulmalıdır action class ından.

        Actions actions=new Actions(driver);

        //amazona  a git account and list ten create a list linkini yıklayın
        WebElement accountListElementi=driver.findElement(By.xpath("//*[text()='Account & Lists']"));

        actions.moveToElement(accountListElementi).perform();//actions da mutlaka sonuna perform dememiz gerekiyor.
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        Thread.sleep(3000);

    }




}
