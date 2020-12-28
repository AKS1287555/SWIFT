package LoginCredentials;

import Library.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class EnterLoginDetails {

    public static void EnterLoginCredentials(WebDriver driver, String Username, String Password) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='tempusername']")).sendKeys(Username); //Passing username
        driver.findElement(By.xpath("//input[@id='temppassword']")).sendKeys(Password); //Passing Password
        Thread.sleep(3000);
        Utility.captureScreenShot(driver, "LoginDetails");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}

