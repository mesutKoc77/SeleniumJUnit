package ders11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {
    // amazon anasayfaya gidin
    // en alttaki web table'da 10 satir oldugunu test edin
    // sutun sayisinin 14 oldugunu test edin
    // 3. sutunu yazdirin
    // 5.satiri yazdirin
    // 3.satir, 5.sutundaki basligin Home Service oldugunu test edin
    // satir ve sutun degerlerini verdigimizde tablodaki o bolumu yazdiracak bir method olusturun

    @Test
    public void test01(){
        //1
        driver.get("https://www.amazon.com");
      List<WebElement> theListOfRaws=driver.findElements(By.xpath("//table//tbody//tr"));
      int expectedNumber=10;
      int actualsize=theListOfRaws.size();
      Assert.assertEquals(expectedNumber,actualsize);

      //2
      List<WebElement> dataList=driver.findElements(By.xpath("//table//tr[1]//td"));
      //System.out.println(dataList.size());
        int expectedDataNumber=14;
        int actualNumberOfData=dataList.size();
        Assert.assertEquals(expectedDataNumber,actualNumberOfData);

        //3
      List<WebElement> thirdData=driver.findElements(By.xpath("//table//td[3]"));
      int sutun=1;
        for (WebElement each:thirdData
             ) {
            System.out.println(sutun+":"+" "+each.getText());
            sutun++;
        }

        // 5.satiri yazdirin
        System.out.println("==============================");

       List<WebElement> theFifthRowElements=driver.findElements(By.xpath("//table//tr[5]"));
        int satir=1;
        for (WebElement each:theFifthRowElements
             ) {
            System.out.println(satir+":"+" "+each.getText());
        satir++;
        }

        // 3.satir, 5.sutundaki basligin Home Service oldugunu test edin
        System.out.println("==================");

      WebElement uceBes=driver.findElement(By.xpath("//table//tr[3]//td[5]"));

      String expectedText="Home Service";
      String actualText= uceBes.getText();
      Assert.assertTrue(actualText.contains(expectedText));

        // satir ve sutun degerlerini verdigimizde tablodaki o bolumu yazdiracak bir method olusturun
        System.out.println("metod================");
        tabloYazdirma(3,5);

    }

    public void tabloYazdirma(int satir, int sutun) {

       WebElement ilgili=driver.findElement(By.xpath("//table//tr["+satir+"]//td["+sutun+"]"));
       System.out.println(satir+"inci satirin"+" "+sutun+"inci stunu"+" "+ilgili.getText());
    }

    int sayi;
    String ad="ali"+sayi;

}
