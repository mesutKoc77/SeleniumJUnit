package ders12_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel extends TestBase {
               /*
 7. Dosya yolunu bir String degiskene atayalim
 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
10. WorkbookFactory.create(fileInputStream)
11. Worksheet objesi olusturun workbook.getSheetAt(index)
12. Row objesi olusturun sheet.getRow(index)
13. Cell objesi olusturun row.getCell(index)
     */

    @Test
    public void readExcelTesti() throws IOException {
// 7. Dosya yolunu bir String degiskene atayalim
 String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\testerKursu\\selenium\\kodlar\\ulkeler.xlsx";
 // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
 FileInputStream fis=new FileInputStream(dosyaYolu);
 //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
 //10. WorkbookFactory.create(fileInputStream)
 Workbook workbook= WorkbookFactory.create(fis);
 //29. satırda kod alemimşizde bir workbook oluşturup
 // fis objesi ile okunan excel deki bilgileri workbook a ekledik
 //boylece excel deki datalrın bir kopyasi workbook objesine yuklendi

 //11. Worksheet objesi olusturun workbook.getSheetAt(index)
 Sheet sheet=workbook.getSheet("Sayfa1");
 //12. Row objesi olusturun sheet.getRow(index)
 Row row=sheet.getRow(13);
 //13. Cell objesi olusturun row.getCell(index)
 Cell cell=row.getCell(2);
 //14. satıdaki ulkenin turkcesinin bahreyn oldugunu test edin
        String expected="Bahreyn";
        String actual=cell.toString();
        Assert.assertEquals(expected,actual);

    }
}
