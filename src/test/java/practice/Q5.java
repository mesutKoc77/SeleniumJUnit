package practice;

import com.github.javafaker.Faker;
import org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Q5 extends TestBase {
    /*
     //Test Case 6: Contact Us Form
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test
    public void test01(){

        driver.get("http://automationexercise.com");
        String expected="Automation Exercise";
        String actualText=driver.getTitle();
        assertEquals(expected,actualText);
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();
        assertTrue(driver.findElement(By.xpath("//h2[text()='Get In Touch']")).isDisplayed());
        Faker faker=new Faker();
        WebElement isimkutusu= driver.findElement(By.xpath("//input[@placeholder='Name']"));
        Actions actions=new Actions(driver);
        String email=faker.internet().emailAddress();
        bekle(2);

        actions.click(isimkutusu).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.expression("merhabalar"))
                .sendKeys(Keys.TAB)
                .sendKeys(faker.expression("fdfd")).perform();
        bekle(2);
        WebElement dosyaSec=driver.findElement(By.xpath("//input[@name='upload_file']"));
        String dosyaYolu=System.getProperty("user.home")+"//Desktop//fileTesti//deneme.txt";
        bekle(2);
        dosyaSec.sendKeys(dosyaYolu);
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        driver.switchTo().alert().accept();
        expected="Success! Your details have been submitted successfully.";
        WebElement text=driver.findElement(By.xpath("(//div[text()='Success! Your details have been submitted successfully.'])[1]"));
        actualText=text.getText();
        assertEquals(expected,actualText);
        driver.findElement(By.xpath(" //a[text()=' Home']")).click();
        expected="Automation Exercise";
        actualText=driver.getTitle();
        assertEquals(expected,actualText);

    }

}
