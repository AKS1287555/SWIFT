package DefaultRate;

import Library.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DefaultRatePage {

    public static void DefaultRate(WebDriver driver) throws InterruptedException
    {

        driver.findElement(By.xpath(".//*[@data-ng-click='defaultRates()']")).click();
        Thread.sleep(6000);
        Utility.captureScreenShot(driver,"DefaultRate");
        List<WebElement> AllData = driver.findElements(By.xpath(".//*[@class='i-data-row ng-scope']"));

        if( AllData.size() > 0)
        System.out.println(AllData.size() + " lines present in default rate screen");
        else
        System.out.println("Default rate tab not working");

        driver.findElement(By.xpath(".//*[@class='col-md-11  col-md-11']//*[local-name()='button']")).click();
    }
}
