package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {
        if (extent == null) {
            createReport();
        }
        return extent;
    }

    private static void createReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport");
        spark.config().setReportName("Test Automation Report");
        spark.config().setDocumentTitle("Automation Execution Report");
        spark.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public String captureScreenshot(WebDriver driver, String screenshotName) {
        String path = System.getProperty("C:\\Users\\srikar.kotha\\IdeaProjects\\Capstone_Project") + "/screenshots/" + screenshotName + ".jpg";
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
        return path;
    }

}
