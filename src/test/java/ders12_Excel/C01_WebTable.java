package ders12_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class C01_WebTable extends TestBase {

    @Test
    public void webTableTesti(){
   // Bir Class olusturun D19_WebtablesHomework
// 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
// 2. Headers da bulunan baslıkları yazdirin
    List<WebElement> departments=driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
    String []  elementArr=new String[7];
    int sayi=0;
        for (WebElement each:departments
             ) {
            elementArr[sayi]=each.getText();
            sayi++;
        }
        System.out.println(Arrays.toString(elementArr));//[First Name, Last Name, Age, Email, Salary, Department, Action]
// 3. 3. sutunun basligini yazdirin
        System.out.println(elementArr[2]);//Age
        //ya da
        System.out.println(departments.get(2).getText());//Age
// 4. Tablodaki tum datalari yazdirin
       sayi=1;
        List<WebElement> allData=driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement each2:allData
             ) {
            System.out.println(sayi+": "+each2.getText());
            sayi++;
        }
// 5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("kaç adet data var : "+allData.size());
        //kaçı dolu?

        int sayac=0;
        List<WebElement> tumHepsi=driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement each3:tumHepsi
        ) {
            if (each3.getText().isEmpty()){
                sayac++;
            }
        }
        System.out.println("dolular : "+sayac);

        //ya da kaçı boş degil
        sayac=0;
        List<WebElement> tumHepsi2=driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement each4:tumHepsi2
        ) {
            if (!each4.getText().isBlank()){
                sayac++;
            }
        }
        System.out.println("boş olmayan : "+sayac);

// 6. Tablodaki satir sayisini yazdirin

        List<WebElement> rowElements=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("satir sayisi : "+rowElements.size());

// 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> dataNumber=driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("sutun sayisi: "+dataNumber.size());//sutun sayisi: 7

// 8. Tablodaki 3.kolonu yazdirin
        int ucuncukolonun=1;
        List<WebElement> thirdData=driver.findElements(By.xpath("//div[@class='rt-td'][3]"));
        for (WebElement each4:thirdData
             ) {
            System.out.println(ucuncukolonun+": "+each4.getText());
            ucuncukolonun++;
        }
// 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        List<WebElement> birinciSutun=driver.findElements(By.xpath("//div[@class='rt-td'][1]"));

        for (WebElement each5:birinciSutun
             ) {
            if (each5.getText().equalsIgnoreCase("Kierra")){
                System.out.println("Kierranin Maasi : "+driver.findElement(By.xpath("(//div[@class='rt-td'][5])[3]")).getText());
            }
        }









    }



}
