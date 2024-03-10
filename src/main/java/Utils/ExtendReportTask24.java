package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportTask24 {

	//Public method to get report
	public static ExtentReports getreport() {
		String path= "C:\\Users\\mrajk\\eclipse-workspace\\Task24\\reports\\Task24Report.html"; 

		//Creating a physical reporter
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//To set the title of the report
		reporter.config().setReportName("Task24 Report");

		//Adding automation to physical report
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}