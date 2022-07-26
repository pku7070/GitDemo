package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;


public class Listeners extends base implements ITestListener{  //We are implementing ITestListener Interface..onr of the interface provided by TestNG for all your test
//And below are the methods present in this interface
	
	ExtentReports extent = ExtentReportNG.getreportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>(); // **** for execution in parallel method ****
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		 test = extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);// **** for execution in parallel method ****
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test Passed");
		extenttest.get().log(Status.PASS, "Test Passed"); // **** For parallel execution method;*****
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		//test.log(Status.FAIL, "Test Failed");//Failure report for ExtentReport
		//test.fail(result.getThrowable());          //for the failure logs  //work only for sequential execution not for parallel
		extenttest.get().fail(result.getThrowable()); //****For parallel execution method;*****
		WebDriver driver =null;
		String testmethodName= result.getMethod().getMethodName();
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e) {
			
		}
		try {
			extenttest.get().addScreenCaptureFromPath(getscreenshotpath(testmethodName, driver),result.getMethod().getMethodName() ); //**** putting the screenshot inside the extent Report ****
			// getscreenshotpath(testmethodName, driver); //----for screenshot in the user dir------
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
