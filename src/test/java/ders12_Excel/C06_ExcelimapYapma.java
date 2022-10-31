package ders12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C06_ExcelimapYapma extends TestBase {
    @Test
    public void test01() throws IOException {

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\testerKursu\\selenium\\kodlar\\ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        // Excel'de birden fazla sutun oldugu icin list gibi bir yapiya
        // bu bilgileri depolamak mumkun olmaz
        // reel database'e en yakin java yapisi olan map kullanabiliriz

        // ingilizce ulke ismi key
        // diger 3 bilgiyi birlestirdigimiz String ise value olsun

        Map<String,String> ulkelerMapi=new HashMap<>();//sıralı gelmesini istersen TreeMap yaparsın.//TreeMap<>();
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <sonSatir ; i++) {
            String keyUlke=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+
                    ", "+workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+
                    ", "+workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMapi.put(keyUlke,value);

        }
    // System.out.println(ulkelerMapi);//ornek [Benin=Porto Novo, Benin, Porto Novo]...

        //ingilizce ismi Barbados olan ulkenin başkenti isminin ingilizce olarak Bridgetown oldugunu test edin
        String ilgiliValue=ulkelerMapi.get("Barbados");
        System.out.println(ilgiliValue);//Bridgetown, Barbados, Bridgetown
       String [] arrValue=ilgiliValue.split(",");
      String expectedText="Bridgetown";
      String actualText=arrValue[0];
      Assert.assertEquals(expectedText,actualText);

    }

}
