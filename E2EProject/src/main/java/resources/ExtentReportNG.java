package resources;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportNG {
	static ExtentReports extent;
	
	public static ExtentReports getreportObject() {
		//ExtentReports, ExtentSparkReport
		String path = System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);	
		report.config().setReportName("Web Automation Results");
		report.config().setDocumentTitle("Test Results");
		
		 extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Prashant");
		return extent;
	}

}
