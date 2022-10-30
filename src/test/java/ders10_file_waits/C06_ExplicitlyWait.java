package ders10_file_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C06_ExplicitlyWait {
    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()

    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

    //4. Textbox’in etkin olmadigini(enabled) dogrulayın

    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

    //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

    @Test
    public void C06_ExplicitlyWaitTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement textBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        Assert.assertFalse(textBox.isEnabled());
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        WebElement ItsenabledText= driver.findElement(By.id("message"));
        Assert.assertTrue(ItsenabledText.isDisplayed());
        WebElement enabled= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(enabled.isEnabled());
        driver.close();

    }


}
