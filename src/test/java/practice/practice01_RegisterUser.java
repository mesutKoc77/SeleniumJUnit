package practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class practice01_RegisterUser extends TestBase {
    /*
    Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button

8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

9. Fill details: Title, Name, Email, Password, Date of birth

10. Select checkbox 'Sign up for our newsletter!'

11. Select checkbox 'Receive special offers from our partners!'

12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    @Test
    public void registerUser(){

        driver.navigate().to("http://automationexercise.com");
        WebElement homePage=driver.findElement(By.xpath("//a[text()=' Home'] [@style='color: orange;']"));
        assertTrue(homePage.isDisplayed());
        bekle(1);

        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        assertTrue( driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed());
        bekle(1);

        WebElement nameBox=driver.findElement(By.xpath("//input[@placeholder='Name']"));
        bekle(1);
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        String mail=faker.internet().emailAddress();
        bekle(1);
        actions.click(nameBox).sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).
                sendKeys(mail).perform();
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        bekle(1);

        String expected="ENTER ACCOUNT INFORMATION";
        String actualText=driver.findElement(By.xpath("//b[text()='Enter Account Information']")).getText();
        assertEquals(expected,actualText);
        bekle(1);

        // Title, Name, Email, Password, Date of birth

        WebElement title=driver.findElement(By.xpath("//input[@id='id_gender1']"));
        actions.click(title).sendKeys(Keys.TAB)
                        .sendKeys(faker.name().firstName())
                        .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                        .sendKeys(Keys.TAB).sendKeys("8")
                        .sendKeys(Keys.TAB).sendKeys("April")
                         .sendKeys(Keys.TAB).sendKeys("1989").perform();
        driver.findElement(By.xpath("//input[@id=\"newsletter\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"optin\"]")).click();
        bekle(1);
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number










    }









}
