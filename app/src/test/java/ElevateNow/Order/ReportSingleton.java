package ElevateNow.Order;


import java.io.File;
import java.sql.Timestamp;

import com.relevantcodes.extentreports.ExtentReports;

public class ReportSingleton {

    private static ReportSingleton instanceOfSingletonReport = null;

    private ExtentReports report;

    public static String getTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }

    private ReportSingleton() {
        report = new ExtentReports(System.getProperty("user.dir") + "/report/index.html");
        report.loadConfig(new File("extent_customization_configs.xml"));
    }

    public static ReportSingleton getInstanceOfSingletonReportClass() {
        if (instanceOfSingletonReport == null) {
            instanceOfSingletonReport = new ReportSingleton();
        }
        return instanceOfSingletonReport;
    }

    public ExtentReports getReport() {
        return report;
    }

}