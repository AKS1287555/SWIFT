import DefaultRate.DefaultRatePage;
import Library.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchBar {
    public static void SearchBarSelect(WebDriver driver1, String Option) throws InterruptedException {
        driver1.findElement(By.xpath("//input[@id='contextSearch']")).click();
        //driver.findElement(By.xpath("//input[@id='contextSearch']")).sendKeys("HLR");
        //WebElement Optn = driver.findElement(By.xpath("//[@data-ng-hide='nonVilDashboard']"));
        List<WebElement> allOption = driver1.findElements(By.xpath(".//*[@class='nav nav-tabs demonav']/li"));
        System.out.println("Inside Search tab");
        for ( WebElement AllOpt : allOption )
        {
            System.out.println(AllOpt.getText().trim());
            if(AllOpt.getText().trim().equals(Option)) {
                AllOpt.click();
                Thread.sleep(3000);
                driver1.findElement(By.xpath("//input[@id='contextSearch']")).click();
                Utility.captureScreenShot(driver1,Option);
                if(Option.equals("Recharge & Offers"))
                    DefaultRatePage.DefaultRate(driver1);
                break;
            }
        }



    }
}
