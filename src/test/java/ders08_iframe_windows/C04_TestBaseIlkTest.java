package ders08_iframe_windows;

import org.junit.Test;
import utilities.TestBase;

public class C04_TestBaseIlkTest extends TestBase {


    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test02(){
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test03(){
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
    }



}
