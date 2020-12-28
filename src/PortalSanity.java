import Library.Utility;
import LoginCredentials.EnterLoginDetails;
import ProfileSection.ProfileSectionView;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class PortalSanity {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        WebDriver driver = new ChromeDriver(capability);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //Utility.captureScreenShot(driver,"BrowserStart");// Browser start screenshot captured

        driver.get("https://swiftcrm.vodafoneidea.in/swift-portal/"); //Portal URL passed
        Utility.captureScreenShot(driver,"LoginPage"); //Portal Login page
        System.out.println(driver.getTitle()); //fetch the title of portal page

        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean value = js.executeScript("return document.readyState").toString().equals("complete");

        System.out.println(value);
        if(value) {
            EnterLoginDetails.EnterLoginCredentials(driver, "cor320505", "Dec@2728");
            Thread.sleep(1000);
            Utility.captureScreenShot(driver, "HomePage");

            driver.findElement(By.xpath("//input[@id='mobforward']")).sendKeys("8007650654");
            Utility.captureScreenShot(driver, "EnterMSISDN");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(5000);
            Utility.captureScreenShot(driver, "MsisdnDetails");

            SearchBar.SearchBarSelect(driver, "SIM Search");
            SearchBar.SearchBarSelect(driver, "Recharge & Offers");

            ProfileSectionView.ProfileOption(driver, "My Profile");
            Thread.sleep(5000);
            ProfileSectionView.ProfileOption(driver, "Logout");

            Thread.sleep(20000);
        }
        driver.quit();
    }
}