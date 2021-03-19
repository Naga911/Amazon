package Listeners;


import Reports.ExtentTestManager;
import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class ListenerClass extends ExtentTestManager implements ITestListener {

    private static ExtentReports extent;

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public static void setExtent(ExtentReports extent) {
        ListenerClass.extent = extent;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("on test method " +  getTestMethodName(iTestResult) + " start");


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
//        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        //ExtentTestManager.captureScreenShot(driver);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
     extent = ExtentTestManager.report();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();
    }
}



