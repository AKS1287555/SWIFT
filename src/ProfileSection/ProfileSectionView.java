package ProfileSection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfileSectionView {
    public static  void ProfileOption(WebDriver driver,String option) throws InterruptedException {

        Thread.sleep(10000);
        driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-chevron-down']")).click();
        List<WebElement> ProfileOptns = driver.findElements(By.xpath(".//*[@class='dcrm-access-li']"));
        System.out.println("Inside Profile Section View");
        for ( WebElement PrfAllOpt : ProfileOptns )
        {
            System.out.println(PrfAllOpt.getText().trim());
            if(PrfAllOpt.getText().trim().equals(option)) {
                PrfAllOpt.click();
                break;
            }
        }

    }
}
