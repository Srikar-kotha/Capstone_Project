package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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

}
