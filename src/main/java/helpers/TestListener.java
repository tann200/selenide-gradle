package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

public class TestListener implements ITestListener {

    private final org.slf4j.Logger Logger = LoggerFactory.getLogger(ITestListener.class);


    @Override
    public void onStart(ITestContext testContext) {
        Logger.info("Testsuite is starting");
    }

    @Override
    public void onTestStart(ITestResult result) {
        Date date = new Date(result.getStartMillis());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Tallinn"));
        String dateFormatted = formatter.format(date);
        Logger.info("Test step: "
                + result.getMethod().getMethodName() + " at:" + dateFormatted);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logger.info("Result was: success");
    }

    @Override
    public void onTestFailure(ITestResult result) { Logger.info("Result was: failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger.info("Test was skipped!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but was in success percentage");
    }

    @Override
    public void onFinish(ITestContext context) {
        Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
        for (ITestResult temp : failedTests) {
            ITestNGMethod method = temp.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                failedTests.remove(temp);
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    failedTests.remove(temp);
                }
            }
        }
    }


}
