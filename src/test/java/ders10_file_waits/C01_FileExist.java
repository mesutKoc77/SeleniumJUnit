package ders10_file_waits;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    @Test
    public void test01(){

        System.out.println(System.getProperty("user.dir"));//C:\Users\mesut\IdeaProjects\JUnitInt

        System.out.println(System.getProperty("user.home"));//C:\Users\mesut
        //masaustunde oluşturulan .txt file in path i:
        //C:\Users\mesut\Desktop\fileTesti\deneme.txt
        //download ın yolu
        // C:\Users\mesut\Downloads

        /*
        System.getProperty(''user.home'') tüm bilgisayarlarda kullanıcıya kadar olan path'i verir.
        ve bu kısım her bilgisyar ve kullanıcı için farklıdır.
        user.home dan sonrası ise tum kullanıclar için ortak olabilir.
        ornegin tum kullanıcların masaustu
        user.home\Desktop
        downloads ½90 kullanıcı için
        user.home\Downloads

        eger birden fazla bilgisayarda file ilgili bir test yapacaksak dosya yolunu dinamik olarak oluşturmamız
        gerekmektedir.

         */

        // dinamik dosya yolu olusturma
        // masa ustunde FileTesti diye bir klasor ve onun altinda deneme diye bir text dosyasi icin
        String dosyayolu=System.getProperty("user.home")+"//Desktop//fileTesti//deneme.txt";

        System.out.println(Files.exists(Paths.get(dosyayolu)));//true





    }


}
