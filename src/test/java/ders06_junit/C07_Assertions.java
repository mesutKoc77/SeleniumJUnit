package ders06_junit;

import org.junit.Assert;
import org.junit.Test;

public class C07_Assertions {
    int sayi1=10;
    int sayi2=20;
    int sayi3=30;
    /*
    assert class ındaki hazır methodlar gerçekleşen sonucların beklentilerimize uygun oluğ olmadıgını kontrol eder.
    expexted result ile actual result aynı ise test passed
    expected result ile actual result farklı ise test failed

    test cuumlesi olumlu ise assertTrue
    test cumlesi olumsuz ise assertFalse
    tercih edilir.


    Assertıoın failed oldugu satırda kodalrın calışması durur o method un içerisinde failed olan assertıon dan sonraki
    satırlar çalıştırılmaz.



     */

    @Test
    public void test(){


        /*
        Assert class'inda cok kullanacagimiz 4 hazir method bulunur
        Assert.assertTrue
        Assert.assertFalse
        Assert.assertEquals
        Assert.assertNotEquals
         */

        // sayi1'in sayi2'den kucuk oldugunu test edin

        Assert.assertTrue(sayi1<sayi2);

        // sayi1'in sayi2'den buyuk olmadigini test edin

        Assert.assertFalse(sayi1>sayi2);

        // sayi1'in sayi2'ye esit oldugunu test edin

        Assert.assertEquals(sayi1,sayi2);

    }

    @Test
    public void test02(){
        Assert.assertEquals(sayi3,sayi1+sayi2);
    }

    @Test
    public void test03(){
        Assert.assertNotEquals(sayi3,sayi2);//passed
    }
    @Test
    public void test04(){
        Assert.assertTrue(sayi3==sayi2);//failed
    }

    @Test
    public void test05(){
        Assert.assertFalse(sayi3==sayi2);//passed
    }

    @Test
    public void test06(){
        Assert.assertNotEquals(sayi3, sayi1+sayi2);//failed
    }

    @Test
    public void test07(){
        Assert.assertTrue(sayi3<sayi2);//failed
    }
    @Test
    public void test8(){
        Assert.assertFalse(sayi3>sayi2);//failed
        System.out.println("bu satir yazdırılacak mı");
    }








}
