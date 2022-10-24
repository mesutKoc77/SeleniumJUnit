package ders09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MoveToElement extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists”
        //    menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        WebElement AccountElement=driver.findElement(By.xpath("//a[@data-nav-ref=\"nav_ya_signin\"]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(AccountElement).perform();
        Thread.sleep(3000);


        //3- “Create a list” butonuna basalim
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim

    WebElement YourListsElement=driver.findElement(By.xpath("(//span[@class=\"nav-a-content\"])[1]"));
    Assert.assertTrue(YourListsElement.isDisplayed());
    bekle(5);

    }



}
