package ders09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_DrugAndDrop extends TestBase {

    @Test
    public void test01() throws InterruptedException {

            //Yeni bir class olusturalim: MouseActions2
            //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

            //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElement= driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        WebElement dropHereTarget=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Thread.sleep(5000);
        actions.dragAndDrop(dragMeElement,dropHereTarget).perform();
        Thread.sleep(5000);

            //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedText="Dropped!";
        String actualText=driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        Assert.assertEquals(expectedText,actualText);

    }





}
