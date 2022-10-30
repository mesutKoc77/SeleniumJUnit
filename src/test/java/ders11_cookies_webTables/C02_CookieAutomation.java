package ders11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_CookieAutomation extends TestBase {

        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        //2- tum cookie’leri listeleyin
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun
        // ve sayfaya ekleyin
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        //8- tum cookie’leri silin ve silindigini test edin

    @Test
    public void test01(){
        //1
        driver.get("https://www.amazon.com");
        Set<Cookie> cookiesSet=driver.manage().getCookies();
        //2
        int siraNo=1;
        for (Cookie each:cookiesSet
             ) {
            System.out.println(siraNo+":"+" "+each);
            siraNo++;
        }
        //3
        Assert.assertTrue(cookiesSet.size()>5);
        //4 i18n-prefs=USD;
        Cookie i18nninCookiesi=driver.manage().getCookieNamed("i18n-prefs");
        String actualbununValuesi=i18nninCookiesi.getValue();
        String expectedValue="USD";
        Assert.assertEquals(expectedValue,actualbununValuesi);
        //5
        System.out.println("==============");
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        Set<Cookie> yeniSetCookie=driver.manage().getCookies();
        siraNo=1;
        for (Cookie each:yeniSetCookie
        ) {
            System.out.println(siraNo+":"+" "+each);
            siraNo++;
        }
        //6
        Assert.assertTrue(yeniSetCookie.contains(cookie));
        //7
        int beforeDeletedNumbeOfCookies= yeniSetCookie.size();
        driver.manage().deleteCookieNamed("skin");
        Set<Cookie> theActualestStandOfCookies=driver.manage().getCookies();
        int afterDeleteOfCookies= theActualestStandOfCookies.size();

        Assert.assertEquals(beforeDeletedNumbeOfCookies-1,afterDeleteOfCookies);

        //8
        driver.manage().deleteAllCookies();
        Set<Cookie> end=driver.manage().getCookies();
        int theLatestState= end.size();
        int expectedNumber=0;
        Assert.assertEquals(expectedNumber, theLatestState);
    }

    }



