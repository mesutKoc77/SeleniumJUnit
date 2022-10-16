package ders06_junit;

import org.junit.*;

public class C02_Notasyonlar {

    @BeforeClass
    public static void setupClass(){
        System.out.println("BeforeClass Calıstı");
    }


    @AfterClass
    public static void teardownClass(){
        System.out.println("AfterClass Calıştı");
    }


    @Before
    public void setupMethod(){
        System.out.println("Before Calıstı");
    }


    @After
    public void afterMethod(){
        System.out.println("After Calıstı");
    }

    @Test
    public void test1(){
        System.out.println("Test1 calıstı");
    }

    @Test @Ignore
    public void test2(){
        System.out.println("Test2 calıstı");
    }

    @Test
    public void test3(){
        System.out.println("Test3 calıstı");
    }

}
