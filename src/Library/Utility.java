package Library;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Date;

public class Utility {

    public static void captureScreenShot(WebDriver driver, String ScreenShotName)
    {
        try
        {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            /*Date d =new Date();
            String FileName = d.toString().replace(":","_").replace(" ","_");*/
            FileUtils.copyFile(source,new File("./Screenshots/"+ScreenShotName+/*+FileName+*/".png"));
            System.out.println("Screenshot taken");
        }
        catch (Exception e)
        {
            System.out.println("Error while taking screenshot" + e.getMessage());
        }
    }
}
