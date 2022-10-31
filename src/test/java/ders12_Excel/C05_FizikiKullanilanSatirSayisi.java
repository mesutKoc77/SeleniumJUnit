package ders12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_FizikiKullanilanSatirSayisi {
    @Test
    public void test01() throws IOException {
        // ulkeler excelindeki Sayfa2'de fiziki olarak kullanilan satir sayisinin
        // 15 oldugunu test edin
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\testerKursu\\selenium\\kodlar\\ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        int toplamSatirSayisi= workbook.getSheet("Sayfa2").getLastRowNum();
        // index kullandigi icin satir sayisini bulmak icin 1 ekleyelim
        System.out.println("Toplam satir sayisi : " + (toplamSatirSayisi+1));

        int fizikiKullanilanSatirsayisi= workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        System.out.println("Fiziki kullanilan satir sayisi : " + fizikiKullanilanSatirsayisi);//12
    }
    @Test
    public void benTest() throws IOException {
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\testerKursu\\selenium\\kodlar\\ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook=WorkbookFactory.create(fis);

        int satirSayisi=workbook.getSheet("Sayfa2").getLastRowNum();
        // index kullandigi icin satir sayisini bulmak icin 1 ekleyelim
        System.out.println("satir sayisi : "+satirSayisi+1);//24
        int fizikiKullanilanSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println("ben fiziki : "+fizikiKullanilanSatirSayisi);//12
    }

}
