package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReporterManager {
    public static ExtentReports getReportObject(){
        String reportsDir = System.getProperty("user.dir") + "/reports";
        java.io.File dir = new java.io.File(reportsDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String path = reportsDir + "/AutomationReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Machine User");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        return extent;
    }
}
