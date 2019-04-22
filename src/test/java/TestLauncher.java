import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestLauncher {
    public static void main(String[] args) {
        /*
        Only works with juint 4.12

        And I needed to use 5.4 to use AssertAll
         */

        Result res = JUnitCore.runClasses(BankTest.class);

        for (Failure fail : res.getFailures()){
            System.out.println(fail.toString());
        }
        printResult(res);

        if(res.wasSuccessful()) System.out.println("Success!");
        else {
            System.out.println("Failed!");
            System.exit(1);
        }
    }


    public static void printResult(Result result) {
        System.out.printf("Test ran: %s, Failed: %s%n",
                result.getRunCount(), result.getFailureCount());
    }
}
