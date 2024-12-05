package base;

import Utils.ExcelUtils;
import Utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.RegisterPage;

import java.io.IOException;
import java.time.Duration;

public class Baseclass{

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
    protected RegisterPage registerPage;



    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        ConfigReader reader= new ConfigReader();
        String url = reader.getUrl();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        startReport();
    }

    public void startReport()
    {
        extent=ExtentManager.getReport();
    }

    public void flushReport()
    {
        extent.flush();
    }

    public void createTest(String methodName,String testDescription)
    {
       test= extent.createTest(methodName, testDescription);
    }

    @AfterClass
    public void tearDown()
    {
        flushReport();
        if(driver!=null)
        {
            driver.quit();
        }

    }
}
