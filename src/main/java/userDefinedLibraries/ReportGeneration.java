package userDefinedLibraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportGeneration {
	
	public static ExtentReports report;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlFile;
	
	public static ExtentReports setReport() {
		
		htmlFile = new ExtentHtmlReporter("./Reports/customReport.html");
		report = new ExtentReports();
		report.attachReporter(htmlFile);
		
		return report;
	}
	
}
